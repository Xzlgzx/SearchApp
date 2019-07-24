package com.example.searchapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonApi {

    // input should have been an extra extracted via the intent passed from MainActivity
    String input = "search";

    @GET(input)
    Call<List<Game>> getPost();
}
