package org.example.after;

public class FatMealBuilder extends FastFoodMealBuilder {
    public FatMealBuilder() {}

    @Override
    public void buildMain() {
        meal.setMain("TripleCheddarBaconBurguer");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("MilkShake");
    }

    @Override
    public void buildDessert() {
        meal.setDessert("Large IceCream");
    }

    @Override
    public void buildSide(){
        meal.setSide("Onion Rings");
    }

    @Override
    public void buildGift() {
        meal.setToy("Hospital pass");
    }
}
