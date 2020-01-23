package com.example.mobileprogramming.model;

import java.io.Serializable;

public class Product implements Serializable {

    private String name;
    private String type;
    private double carbohydrates;
    private double fibre;
    private int glycemIndex;
    private String imgUrl;

    public Product(String name, String type, double carbohydrates, double fibre, int glycemIndex, String imgUrl) {
        this.name = name;
        this.type = type;
        this.carbohydrates = carbohydrates;
        this.fibre = fibre;
        this.glycemIndex = glycemIndex;
        this.imgUrl = imgUrl;
    }

    public Product(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public double getFibre() {
        return fibre;
    }

    public void setFibre(double fibre) {
        this.fibre = fibre;
    }

    public int getGlycemIndex() {
        return glycemIndex;
    }

    public void setGlycemIndex(int glycemIndex) {
        this.glycemIndex = glycemIndex;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
