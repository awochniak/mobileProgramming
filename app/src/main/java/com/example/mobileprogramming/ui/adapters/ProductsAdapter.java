package com.example.mobileprogramming.ui.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mobileprogramming.R;
import com.example.mobileprogramming.commons.Utils;
import com.example.mobileprogramming.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ProductsAdapter extends ArrayAdapter<Product> {

    private Context context;
    int resource;

    public ProductsAdapter(Context context, int resource, List<Product> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String name = getItem(position).getName();
        int glycemIndex = getItem(position).getGlycemIndex();
        String imgUrl = getItem(position).getImgUrl();

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource, parent, false);

        TextView title = convertView.findViewById(R.id.prodTit);
        TextView index = convertView.findViewById(R.id.prodInd);
        ImageView imageView = convertView.findViewById(R.id.prodImg);

        title.setText(name.toUpperCase());
        Typeface boldTypeface = Typeface.defaultFromStyle(Typeface.BOLD);
        title.setTypeface(boldTypeface);

        index.setText(String.valueOf(glycemIndex));

        Picasso.get().load(imgUrl).into(imageView);

        return convertView;
    }
}

