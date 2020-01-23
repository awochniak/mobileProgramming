package com.example.mobileprogramming.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.mobileprogramming.R;
import com.example.mobileprogramming.config.Config;
import com.example.mobileprogramming.model.Recipe;
import com.example.mobileprogramming.service.SharedPrefHelper;
import com.example.mobileprogramming.ui.activities.RecipeInfo;
import com.example.mobileprogramming.ui.adapters.RecipesAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;

public class RecipesFragment extends Fragment {

    private SharedPrefHelper helper = new SharedPrefHelper();
    private List<Recipe> recipes = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recipe_list_fragment,container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView listView = getActivity().findViewById(R.id.recipeListView);
        LinearLayout errorLinearLayout = getActivity().findViewById(R.id.error);
        LinearLayout successLinearLayout = getActivity().findViewById(R.id.recipeContent);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(Config.SP_TAG, Context.MODE_PRIVATE);
        recipes = helper.loadData(sharedPreferences);

        if(recipes.isEmpty()){
            errorLinearLayout.setVisibility(View.VISIBLE);
            successLinearLayout.setVisibility(View.GONE);
        } else {
            errorLinearLayout.setVisibility(View.GONE);
            successLinearLayout.setVisibility(View.VISIBLE);
        }

        RecipesAdapter recipesAdapter = new RecipesAdapter(getContext(), R.layout.recipe_list_fragment_element, recipes);
        listView.setAdapter(recipesAdapter);
        listView.setOnItemClickListener((adapterView, v, i, l) -> {

            Intent intent = new Intent(getActivity(), RecipeInfo.class);
            putExtraDataToIntent(i, intent);
            startActivity(intent);

        });
    }

    private void putExtraDataToIntent(int i, Intent intent) {
        intent.putExtra("recipe_name", recipes.get(i).getName());
        intent.putExtra("recipe_index", recipes.get(i).getIndex());

        int productsArrayLength = recipes.get(i).getIngredientList().size();

        intent.putExtra("recipe_product_length", productsArrayLength);

        for(int x = 0; x < productsArrayLength; x++){
            intent.putExtra("recipe_product_" + x, recipes.get(i).getIngredientList().get(x));
        }
    }

}