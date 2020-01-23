package com.example.mobileprogramming.ui.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobileprogramming.R;
import com.example.mobileprogramming.model.Product;
import com.example.mobileprogramming.service.DBHelper;

import java.util.ArrayList;
import java.util.List;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AddProductFragment extends Fragment {

    private DBHelper dbHelper = new DBHelper();
    private List<EditText> editTexts = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add_product_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button add = getActivity().findViewById(R.id.addProductButton);
        EditText name = getActivity().findViewById(R.id.addProductNameValue);
        EditText type = getActivity().findViewById(R.id.addProductTypeValue);
        EditText carbo = getActivity().findViewById(R.id.addProductCarboValue);
        EditText fibre = getActivity().findViewById(R.id.addProductFibreValue);
        EditText index = getActivity().findViewById(R.id.addProductIndexValue);
        EditText url = getActivity().findViewById(R.id.addProductImgUrlValue);

        editTexts.add(name);
        editTexts.add(type);
        editTexts.add(carbo);
        editTexts.add(fibre);
        editTexts.add(index);
        editTexts.add(url);

        add.setEnabled(false);

        add.setOnClickListener(v ->
                {
                    Product product = new Product(
                                        name.getText().toString(),
                                        type.getText().toString(),
                                        Double.valueOf(carbo.getText().toString()),
                                        Double.valueOf(fibre.getText().toString()),
                                        Integer.parseInt(index.getText().toString()),
                                        url.getText().toString()
                                     );

                    dbHelper.addProduct(product);
                    clearInputTexts(name, type, carbo, fibre, index, url);
                    Toast.makeText(getContext(), "Pomyślnie dodano do bazy danych", Toast.LENGTH_SHORT).show();
                }
        );

        editTexts.forEach(editText -> {
            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    String et1 = name.getText().toString();
                    String et2 = type.getText().toString();
                    String et3 = carbo.getText().toString();
                    String et4 = fibre.getText().toString();
                    String et5 = index.getText().toString();
                    String et6 = url.getText().toString();

                    add.setEnabled(checkEditTextsNotNull(et1, et2, et3, et4, et5, et6));
                }

                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void afterTextChanged(Editable editable) {
                }
            });
        });
    }

    private void clearInputTexts(EditText name, EditText type, EditText carbo, EditText fibre, EditText index, EditText url) {
        name.getText().clear();
        type.getText().clear();
        carbo.getText().clear();
        fibre.getText().clear();
        index.getText().clear();
        url.getText().clear();
    }

    private boolean checkEditTextsNotNull(String et1, String et2, String et3, String et4, String et5, String et6) {
        return !et1.isEmpty() &&
                !et2.isEmpty() &&
                !et3.isEmpty() &&
                !et4.isEmpty() &&
                !et5.isEmpty() &&
                !et6.isEmpty();
    }
}