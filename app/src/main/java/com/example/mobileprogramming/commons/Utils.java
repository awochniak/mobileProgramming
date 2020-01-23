package com.example.mobileprogramming.commons;

import android.graphics.Color;
import android.widget.TextView;

public class Utils {
    public static void setIndexColor(TextView index, double value) {
        if(value<=55){
            index.setTextColor(Color.GREEN);
        } else if (value>=70){
            index.setTextColor(Color.rgb(255,140,0));
        } else {
            index.setTextColor(Color.YELLOW);
        }
    }
}
