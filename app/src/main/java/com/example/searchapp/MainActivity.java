package com.example.searchapp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ir.mirrajabi.searchdialog.SimpleSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.BaseSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.SearchResultListener;
import ir.mirrajabi.searchdialog.core.Searchable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity"; //Testing only
    private TextView textViewResult;// Testing only
    private GameSearch newGameSearch = new GameSearch();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // textViewResult is used to display status of GET request to the server after
        textViewResult = findViewById(R.id.HTTP_Status);

        // Creates an instance of Retrofit used to connect to server to make GET request
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://localhost:8080/").
                addConverterFactory(GsonConverterFactory.create()).build();

        JsonApi holderApi = retrofit.create(JsonApi.class);

        Call<List<Game>> call = holderApi.getPost();

        //Dealing with the response from the server
        call.enqueue(new Callback<List<Game>>() {

            @Override
            public void onResponse(Call<List<Game>> call, Response<List<Game>> response) {

                // Response failed, display message sent back from server
                if(!response.isSuccessful()){
                    textViewResult.setText(response.code());
                    return;
                }

                // Proceed to display basic info received from server for testing purpose,
                // and save each game in newGameSearch used later for search result
                List<Game> posts = response.body(); // avoid calling to the main thread!
                for(Game post : posts){
                    newGameSearch.findGame(post);
                    String content = "";
                    content += "Our App: " + post.getBasicInfo() + "\n";
                    textViewResult.append(content); // Display the the information of app
                }
            }

            // Respond to failure
            @Override
            public void onFailure(Call<List<Game>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });

        // Start the search now and returning the result
        startSearch();
    }

    // Returns the list of games used for search
    private ArrayList<Game> getGameList(){
        return newGameSearch.getGame();
    }

    private void startSearch(){
        findViewById(R.id.gameSearch).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new SimpleSearchDialogCompat(MainActivity.this, "Comprehensive Game Search",
                        "Tell me about the games you want?", null, getGameList(),
                        new SearchResultListener<Game>() {
                            @Override
                            public void onSelected(BaseSearchDialogCompat dialog,
                                                   Game item, int position) {
                                Toast.makeText(MainActivity.this, item.getBasicInfo(),
                                        Toast.LENGTH_LONG).show();
                                dialog.dismiss();
                            }
                        }).show();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }


    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

}
