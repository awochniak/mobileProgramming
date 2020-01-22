package com.example.mobileprogramming;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

public class ListFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference(Config.PRODUCTS_COLLECTION_NAME);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Product> products = new ArrayList<>();
                for (DataSnapshot ds: dataSnapshot.getChildren()){
                    Product product = ds.getValue(Product.class);
                    products.add(product);
                }
                System.out.println(products);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Log.e("Problem with DB connection");
            }
        });


        return inflater.inflate(R.layout.list_fragment,container, false);
    }
}
