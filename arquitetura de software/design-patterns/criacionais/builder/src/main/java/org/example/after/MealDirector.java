package org.example.after;

import org.example.model.FastFoodMeal;

public class MealDirector {
    private FastFoodMealBuilder builder;

    public MealDirector(FastFoodMealBuilder builder) {
        this.builder = builder;
    }

    public void constructCombo(){
        builder.buildDrink();
        builder.buildDessert();
        builder.buildGift();
        builder.buildMain();
        builder.buildSide();
    }

    public FastFoodMeal getCombo(){
        return builder.getMeal();
    }
}
