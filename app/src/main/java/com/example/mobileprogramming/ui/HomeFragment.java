package com.example.mobileprogramming.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobileprogramming.R;
import com.example.mobileprogramming.config.Config;
import com.example.mobileprogramming.model.Product;
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
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

/*

        // kolekcja
        DatabaseReference myRef = database.getReference();

        dodawanie produktu
        Product product = new Product("piwo", "napoje", 3.55, 0.2, 110, "https://twojbrowar.pl/2716-large_pp/polskie-jasne-zestaw-surowcow-na-piwo-domowe.jpg");

        // dokument
        myRef.child("piwo").setValue(product);*/

        return inflater.inflate(R.layout.fragment_home,container, false);
    }
}
