package com.example.mobileprogramming.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mobileprogramming.R;
import com.example.mobileprogramming.model.Product;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;

public class ProductInfo extends AppCompatActivity {

    private Product product;

    @Override
    public void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_view);

        product = getFromExtras();

        TextView title = findViewById(R.id.productPageTitle);
        TextView name = findViewById(R.id.nameValue);
        TextView type = findViewById(R.id.typeValue);
        TextView carbo = findViewById(R.id.carboValue);
        TextView fibre = findViewById(R.id.fibreValue);
        TextView index = findViewById(R.id.indexValue);
        ImageView img = findViewById(R.id.imageView);

        title.setText(product.getName().toUpperCase());
        name.setText(product.getName());
        type.setText(product.getType());
        carbo.setText(String.valueOf(product.getCarbohydrates()));
        fibre.setText(String.valueOf(product.getFibre()));
        index.setText(String.valueOf(product.getGlycemIndex()));
        Picasso.get().load(product.getImgUrl()).into(img);

        if(product.getGlycemIndex()<=55){
            index.setTextColor(Color.GREEN);
        } else if (product.getGlycemIndex()>=70){
            index.setTextColor(Color.RED);
        } else {
            index.setTextColor(Color.YELLOW);
        }

    }

    private Product getFromExtras() {
        Intent i = getIntent();
        Bundle b = i.getExtras();
        return (Product) b.get("product");
    }
}

