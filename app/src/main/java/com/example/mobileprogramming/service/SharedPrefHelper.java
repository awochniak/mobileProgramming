package com.example.mobileprogramming.service;

import android.content.SharedPreferences;

import com.example.mobileprogramming.model.Recipe;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SharedPrefHelper {

    private List<Recipe> recipes = new ArrayList<>();

    public void saveData(SharedPreferences sharedPreferences, Recipe recipe){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(recipe);
        editor.putString(recipe.getName(), json);
        editor.apply();
    }

    public List<Recipe> loadData(SharedPreferences sharedPreferences){
        Map<String, ?> map = sharedPreferences.getAll();
        map.forEach((s, o) ->
                decodeSpecificKey(sharedPreferences, s));
        return recipes;
    }

    private void decodeSpecificKey(SharedPreferences sharedPreferences, String key){
        Gson gson = new Gson();
        String json = sharedPreferences.getString(key,null);
        Type type = new TypeToken<Recipe>() {}.getType();
        Recipe recipe = gson.fromJson(json, type);
        recipes.add(recipe);
    }
}
