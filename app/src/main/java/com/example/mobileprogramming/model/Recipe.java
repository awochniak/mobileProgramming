package com.example.mobileprogramming.model;

import java.util.List;

public class Recipe {
    private String name;
    private List<Ingredient> ingredientList;

    public Recipe(String name, List<Ingredient> ingredientList) {
        this.name = name;
        this.ingredientList = ingredientList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }
}
