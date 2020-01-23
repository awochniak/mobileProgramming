package com.example.mobileprogramming.model;

import java.io.Serializable;

public class Ingredient implements Serializable {

    private String imgUrl;
    private String name;
    private double weight;

    public Ingredient(String imgUrl, String name, double weight) {
        this.imgUrl = imgUrl;
        this.name = name;
        this.weight = weight;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
