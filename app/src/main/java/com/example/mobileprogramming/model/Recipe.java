package com.example.mobileprogramming.model;

import java.util.List;

public class Recipe {
    private String name;
    private double index;
    private List<Ingredient> ingredientList;

    public Recipe(String name, double index, List<Ingredient> ingredientList) {
        this.name = name;
        this.index = index;
        this.ingredientList = ingredientList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getIndex() {
        return index;
    }

    public void setIndex(double index) {
        this.index = index;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }
}
