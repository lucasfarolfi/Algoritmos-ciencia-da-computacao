package org.example.fluent;

public class FastFoodMealBuilder {
    // mandatory
    private String side;

    // optionals
    private String main;
    private String drink;
    private String dessert;
    private String gift;

    public FastFoodMealBuilder(String side){
        this.side = side;
    }


    public FastFoodMealBuilder forDrink(String drink){
        this.drink = drink;
        return this;
    }
    public FastFoodMealBuilder andMain(String main){
        this.main = main;
        return this;
    }
    public FastFoodMealBuilder andDessert(String dessert){
        this.dessert = dessert;
        return this;
    }

    public FastFoodMealBuilder andGift(String gift){
        this.gift = gift;
        return this;
    }

    public FastFoodMeal thatsAll(){
        return new FastFoodMeal(drink, main, side, dessert, gift);
    }
}
