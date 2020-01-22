package com.example.mobileprogramming.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mobileprogramming.R;
import com.example.mobileprogramming.config.Config;
import com.example.mobileprogramming.model.Product;
import com.example.mobileprogramming.service.DBHelper;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    private final DBHelper dbHelper = new DBHelper();
    private List<Product> products = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button addDb = getActivity().findViewById(R.id.addDb);
        addDb.setOnClickListener(v ->
                System.out.println("ok"));
//        products.add(new Product("awokado", "warzywa", 10, 6.7, 10, "https://static.wixstatic.com/media/2cd43b_7b2fea2d48554a688c73b62fba457df2~mv2.png"));
//        products.add(new Product("jaja", "nabiał", 1.77, 0.9, 0, "https://www.freepnglogos.com/uploads/egg-png/download-egg-png-transparent-image-and-clipart-33.png"));
//        dbHelper.addProducts(products);
    }
}
