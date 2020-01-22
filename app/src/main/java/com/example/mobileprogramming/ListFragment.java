package com.example.mobileprogramming;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.mobileprogramming.service.DBHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ListFragment extends Fragment {

    private final DBHelper dbHelper = new DBHelper();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_fragment,container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView listView = view.findViewById(R.id.listView);

        dbHelper.getProducts(products -> {
            ProductsAdapter adapter = new ProductsAdapter(getContext(), R.layout.list_element, products);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener((adapterView, view1, i, l) -> System.out.println(i));
        });
    }
}
