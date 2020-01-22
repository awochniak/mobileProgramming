package com.example.mobileprogramming.infrastructure;

import com.example.mobileprogramming.model.Ingredient;
import com.example.mobileprogramming.model.Product;

import java.util.ArrayList;
import java.util.List;

public class GlycemicalLoadCalc {

    private List<Double> multiplier = new ArrayList<>();
    private List<Double> multipliedCarbohydrates = new ArrayList<>();
    private List<Double> multipliedFibres = new ArrayList<>();
    private List<Double> availableCarbohydrates = new ArrayList<>();
    private List<Double> percentageCarboInMeal = new ArrayList<>();
    private double availableCarbohydratesSum;
    private double glycemicalIndex;

    public double getGlycemicalLoad(List<Product> products, List<Ingredient> ingredients){

        clearOldData();
        calcMultiplier(ingredients);
        calcMultipliedCarbohydrates(products);
        calcMultipliedFibres(products);
        calcAvaiableCarbohydrates(products);
        sumAvaiableCarbohydrates();
        calcPercentageCarboInMeal(products);
        calcGlycemicalndex(products);

        return glycemicalIndex;

    }

    private void clearOldData() {
        multiplier.clear();
        multipliedCarbohydrates.clear();
        multipliedFibres.clear();
        availableCarbohydrates.clear();
        percentageCarboInMeal.clear();
        availableCarbohydratesSum = 0;
        glycemicalIndex = 0;
    }

    private void calcGlycemicalndex(List<Product> products) {
        for (int i = 0; i < products.size(); i ++) {
            glycemicalIndex += products.get(i).getGlycemIndex() * percentageCarboInMeal.get(i);
        }
    }

    private void calcMultiplier(List<Ingredient> ingredients) {
        ingredients.forEach(ingredient -> {
            multiplier.add(ingredient.getWeight() / 100);
        });
    }

    private void calcMultipliedCarbohydrates(List<Product> products) {
        for (int i = 0; i < products.size(); i ++) {
            multipliedCarbohydrates.add(products.get(i).getCarbohydrates() * multiplier.get(i));
        }
    }

    private void calcMultipliedFibres(List<Product> products) {
        for (int i = 0; i < products.size(); i ++) {
            multipliedFibres.add(products.get(i).getFibre() * multiplier.get(i));
        }
    }

    private void calcAvaiableCarbohydrates(List<Product> products) {
        for (int i = 0; i < products.size(); i ++) {
            availableCarbohydrates.add(multipliedCarbohydrates.get(i) - multipliedFibres.get(i));
        }
    }

    private void sumAvaiableCarbohydrates() {
        availableCarbohydrates.forEach(val -> availableCarbohydratesSum += val);
    }

    private void calcPercentageCarboInMeal(List<Product> products) {
        for (int i = 0; i < products.size(); i ++) {
            percentageCarboInMeal.add(availableCarbohydrates.get(i) / availableCarbohydratesSum);
        }
    }
}
