package com.example.mobileprogramming.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mobileprogramming.R;
import com.example.mobileprogramming.commons.Utils;
import com.example.mobileprogramming.model.Ingredient;
import com.example.mobileprogramming.model.Product;
import com.example.mobileprogramming.model.Recipe;
import com.example.mobileprogramming.ui.adapters.IngredientAdapter;

import java.sql.SQLOutput;
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

        TextView title = findViewById(R.id.singleRecipeName);
        TextView index = findViewById(R.id.singleRecipeIndexValue);

        ListView listView = findViewById(R.id.ingredientsListView);

        Utils.setIndexColor(index, recipeIndex);

        title.setText(recipeTitle.toUpperCase());
        index.setText(String.valueOf(recipeIndex));

        for (int x = 0; x < recipeProductLength ; x++) {
            ingredients.add((Ingredient) b.get("recipe_product_" + x));
        }

        IngredientAdapter adapter = new IngredientAdapter(getBaseContext(), R.layout.ingredient, ingredients);
        listView.setAdapter(adapter);

    }

    private Recipe getFromExtras() {
        Intent i = getIntent();
        Bundle b = i.getExtras();
        return (Recipe) b.get("recipe");
    }
}
