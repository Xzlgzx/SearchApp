package com.example.searchapp;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import ir.mirrajabi.searchdialog.core.Searchable;

public class GameSearch {
    private ArrayList<Game> mCrimes = new ArrayList<>();

    public void findGame(Game game){
        mCrimes.add(game);
    }

    public ArrayList<Game> getGame(){
        return mCrimes;
    }

}
