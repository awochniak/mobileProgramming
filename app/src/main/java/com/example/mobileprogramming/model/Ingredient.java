package com.example.mobileprogramming.model;

public class Ingredient {

    private String imgUrl;
    private String name;
    private String weight;

    public Ingredient(String imgUrl, String name, String weight) {
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

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
