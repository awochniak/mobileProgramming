package com.example.mobileprogramming.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.telecom.InCallService;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobileprogramming.R;
import com.example.mobileprogramming.infrastructure.IngredientAdapter;
import com.example.mobileprogramming.model.Ingredient;
import com.google.android.material.bottomnavigation.BottomNavigationView;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.fragment.app.Fragment;

public class AboutFragment extends Fragment {

    private List<Ingredient> ingredients = new ArrayList<>();
    private IngredientAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.calc_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        BottomNavigationView navBar = getActivity().findViewById(R.id.bottom_navigation);

        ListView listView = getActivity().findViewById(R.id.ingrListView);
        EditText gram = getActivity().findViewById(R.id.weightValue);
        EditText dishName = getActivity().findViewById(R.id.dishValue);
        TextView title = getActivity().findViewById(R.id.dishName);

        hideNavbarWhenKeyboardAppear(navBar, gram);

        ingredients.add(new Ingredient("test","test", 2.0));
        adapter = new IngredientAdapter(getContext(), R.layout.ingredient, ingredients);
        listView.setAdapter(adapter);

        Button button = getActivity().findViewById(R.id.addButton);

        button.setOnClickListener(v -> {
            double weight = Double.parseDouble(gram.getText().toString());
            Ingredient ingredient = new Ingredient(
                "dasd","dad" , weight
            );
            ingredients.add(ingredient);
            adapter.notifyDataSetChanged();
            gram.setText("");
        });

    }

    private void hideNavbarWhenKeyboardAppear(BottomNavigationView navBar, EditText gram) {
        gram.setImeOptions(EditorInfo.IME_ACTION_DONE);
        gram.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (keyboardShown(gram.getRootView())) {
                    navBar.setVisibility(View.GONE);
                } else {
                    navBar.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private boolean keyboardShown(View rootView) {
        final int softKeyboardHeight = 100;
        Rect r = new Rect();
        rootView.getWindowVisibleDisplayFrame(r);
        DisplayMetrics dm = rootView.getResources().getDisplayMetrics();
        int heightDiff = rootView.getBottom() - r.bottom;
        return heightDiff > softKeyboardHeight * dm.density;
    }

}
