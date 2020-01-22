package com.example.mobileprogramming.ui.fragments;

import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.mobileprogramming.R;
import com.example.mobileprogramming.commons.Utils;
import com.example.mobileprogramming.infrastructure.GlycemicalLoadCalc;
import com.example.mobileprogramming.ui.adapters.IngredientAdapter;
import com.example.mobileprogramming.model.Ingredient;
import com.example.mobileprogramming.model.Product;
import com.example.mobileprogramming.service.DBHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;


import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;

public class AboutFragment extends Fragment {

    private GlycemicalLoadCalc glc = new GlycemicalLoadCalc();
    private DBHelper dbHelper = new DBHelper();

    private List<Product> productsArray = new ArrayList<>();
    private List<Product> selectedProductsArray = new ArrayList<>();
    private List<Ingredient> ingredients = new ArrayList<>();
    private List<String> spinnerArray = new ArrayList<>();

    private IngredientAdapter adapter;
    private ArrayAdapter<String> spinnerAdapter;

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
        TextView glycIndex = getActivity().findViewById(R.id.glycIndex);

        Button button = getActivity().findViewById(R.id.addButton);
        Button countButton = getActivity().findViewById(R.id.countButton);

        Spinner spinner = getActivity().findViewById(R.id.spinnerValue);

        hideNavbarWhenKeyboardAppear(navBar, gram);
        bindElementWithListView(listView);
        listenToButtonClick(gram, button, spinner);

        dbHelper.getProducts(
            products -> {
                products.forEach(
                    product -> {
                        addDataToTempArrays(product);
                    });
                setDataForSpinner(spinner);
            }
        );

        countButton.setOnClickListener(v -> {
            Double index = glc.getGlycemicalLoad(selectedProductsArray, ingredients);
            glycIndex.setText(String.valueOf(Math.round(index)));
            Utils.setIndexColor(glycIndex, index);
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

    private void bindElementWithListView(ListView listView) {
        adapter = new IngredientAdapter(getContext(), R.layout.ingredient, ingredients);
        listView.setAdapter(adapter);
    }

    private void listenToButtonClick(EditText gram, Button button, Spinner spinner) {
        button.setOnClickListener(v -> {

            long indexOfElement = spinner.getSelectedItemId();
            double weight = Double.valueOf(gram.getText().toString());
            String nameOfIngredient = spinner.getSelectedItem().toString();
            String imgUri = productsArray.get((int)indexOfElement).getImgUrl();

            Ingredient ingredient = new Ingredient(
                    imgUri,nameOfIngredient,weight
            );

            Product product =
                    new Product(
                        productsArray.get((int)indexOfElement).getName(),
                        productsArray.get((int)indexOfElement).getType(),
                        productsArray.get((int)indexOfElement).getCarbohydrates(),
                        productsArray.get((int)indexOfElement).getFibre(),
                        productsArray.get((int)indexOfElement).getGlycemIndex(),
                        productsArray.get((int)indexOfElement).getImgUrl()
                    );

            ingredients.add(ingredient);
            selectedProductsArray.add(product);
            adapter.notifyDataSetChanged();
            gram.setText("");

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

    private void addDataToTempArrays(Product product) {
        spinnerArray.add(product.getName());
        productsArray.add(product);
    }

    private void setDataForSpinner(Spinner spinner) {
        spinnerAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, spinnerArray);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(spinnerAdapter);
    }

}
