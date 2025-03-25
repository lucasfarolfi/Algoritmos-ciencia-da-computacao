package org.example.after;

import org.example.model.FastFoodMeal;

public abstract class FastFoodMealBuilder {
    protected FastFoodMeal meal;

    public FastFoodMealBuilder(){
        meal = new FastFoodMeal();
    }

    public FastFoodMeal getMeal(){
        return meal;
    }

    public abstract void buildMain();
    public abstract void buildDrink();
    public abstract void buildDessert();
    public abstract void buildSide();
    public abstract void buildGift();
}
