package com.example.searchapp;

import com.google.gson.annotations.SerializedName;

import ir.mirrajabi.searchdialog.core.Searchable;
import retrofit2.http.POST;

// Game is an instance of
public class Game implements Searchable {
    @SerializedName("title")
    private String mTitle;
    @SerializedName("genre")
    private String mGenre;
    @SerializedName("imgURL")
    private String mImgURL;
    @SerializedName("subgenre")
    private String mSubgenre;
    @SerializedName("pid")
    private String mPid;
    @SerializedName("rating")
    private String mRating;
    @SerializedName("rCount")
    private String mRCount;

    // Return only title since only title will be displayed in the search list
    @Override
    public String getTitle() {
        return mTitle;
    }

    public String getGenre() {
        return mGenre;
    }

    public String getImgURL() {
        return mImgURL;
    }

    public String getSubgenre() {
        return mSubgenre;
    }

    public String getPid() {
        return mPid;
    }

    public String getRating() {
        return mRating;
    }

    public String getRCount() {
        return mRCount;
    }

    // Function used to return the string needed to display on the toast after clicking on
    // one of the search results.
    public String getBasicInfo() {
        return mTitle + " is a " + mGenre + " game. It has received a rating of " +
                mRating + " with " + mRCount + " reviews. Please visit " + mSubgenre +
                " for more details.";
    }
}
