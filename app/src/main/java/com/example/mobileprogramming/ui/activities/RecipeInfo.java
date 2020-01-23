package com.example.mobileprogramming.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.example.mobileprogramming.R;
import com.example.mobileprogramming.model.Ingredient;
import com.example.mobileprogramming.model.Product;
import com.example.mobileprogramming.model.Recipe;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class RecipeInfo extends AppCompatActivity {

    private List<Ingredient> ingredients = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_view);

        Intent i = getIntent();
        Bundle b = i.getExtras();

        String recipeTitle = (String) b.get("recipe_name");

        //TODO typ
        double recipeIndex = (double) b.get("recipe_index");
        int recipeProductLength = (int) b.get("recipe_product_length");

        System.out.println(recipeIndex);
        System.out.println(recipeTitle);
        System.out.println(recipeProductLength);

        for (int x = 0; x < recipeProductLength ; x++) {
            ingredients.add((Ingredient) b.get("recipe_product_" + x));
        }

        System.out.println(ingredients);
    }

    private Recipe getFromExtras() {
        Intent i = getIntent();
        Bundle b = i.getExtras();
        return (Recipe) b.get("recipe");
    }
}
