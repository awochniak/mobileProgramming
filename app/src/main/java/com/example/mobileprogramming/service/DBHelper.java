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

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference ref = database.getReference(Config.PRODUCTS_COLLECTION_NAME);

    public void getProducts(FirebaseDBCallback callback){
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

    public void addProducts(List<Product> products){
        products.forEach(product -> ref.push().setValue(product));
    }
    public void addProduct(Product product){
       ref.push().setValue(product);
    }
    public interface FirebaseDBCallback {
        void onCallback(List<Product> products);
    }
}


