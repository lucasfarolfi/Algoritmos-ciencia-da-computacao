package org.example.after;

import org.example.model.FastFoodMeal;

public class Client {

	public static void order(String name, FastFoodMealBuilder builder) {
		System.out.println("Ordering a " + name);
		var director = new MealDirector(builder);
		director.constructCombo();
		System.out.println(director.getCombo());
		System.out.println("-------------------");
	}
	
	public static void main(String[] args) {
		order("Xburguer", new FatMealBuilder());
		order("Fries", new JustFriesBuilder());
		order("Heart attack", new FatMealBuilder());
	}
}