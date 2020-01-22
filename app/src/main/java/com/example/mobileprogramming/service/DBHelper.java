package com.example.mobileprogramming.service;

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

public class DBHelper {
    public void getProducts(FirebaseDBCallback callback){
        System.out.println("weszło");
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
                callback.onCallback(products);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Log.e("Problem with DB connection");
            }
        });
    }

    public interface FirebaseDBCallback {
        void onCallback(List<Product> products);
    }
}


