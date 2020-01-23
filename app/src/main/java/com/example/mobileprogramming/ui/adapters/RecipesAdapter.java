package com.example.mobileprogramming.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mobileprogramming.R;
import com.example.mobileprogramming.model.Recipe;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecipesAdapter extends ArrayAdapter<Recipe> {

    private Context context;
    int resource;

    public RecipesAdapter(Context context, int resource, List<Recipe> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String name = getItem(position).getName();
        double glycemicIndex = getItem(position).getIndex();

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource, parent, false);

        TextView title = convertView.findViewById(R.id.recTitle);
        TextView index = convertView.findViewById(R.id.recIndex);

        title.setText(name);
        index.setText(String.valueOf(glycemicIndex));

        return convertView;
    }
}
