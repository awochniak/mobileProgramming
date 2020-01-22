package com.example.mobileprogramming.service;

import android.content.SharedPreferences;

import com.example.mobileprogramming.model.Recipe;
import com.google.gson.Gson;

public class SharedPrefHelper {

    public void saveData(SharedPreferences sharedPreferences, Recipe recipe){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(recipe);
        editor.putString(recipe.getName(), json);
        editor.apply();
    }

    public void loadData(SharedPreferences sharedPreferences){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = sharedPreferences.getString("test",null);
        System.out.println(json);
    }
}
