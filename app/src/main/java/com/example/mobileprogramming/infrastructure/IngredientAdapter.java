package com.example.mobileprogramming.infrastructure;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mobileprogramming.R;
import com.example.mobileprogramming.model.Ingredient;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;

public class IngredientAdapter extends ArrayAdapter<Ingredient> {

    private Context context;
    int resource;

    public IngredientAdapter(Context context, int resource, List<Ingredient> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String name = getItem(position).getName();
        String weight = getItem(position).getWeight();
        String imgUrl = getItem(position).getImgUrl();

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource, parent, false);

        TextView title = convertView.findViewById(R.id.ingrTitle);
        TextView weightOfProduct = convertView.findViewById(R.id.ingrWeight);
        ImageView imageView = convertView.findViewById(R.id.ingrImg);

        title.setText(name);
        weightOfProduct.setText(weight);
        Picasso.get().load(imgUrl).into(imageView);

        return convertView;
    }
}
