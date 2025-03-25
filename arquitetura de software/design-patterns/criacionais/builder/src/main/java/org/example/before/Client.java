package org.example.before;

import org.example.model.FastFoodMeal;

public class Client {
	
	public static void main(String[] args) {
		var meal = new FastFoodMeal();
		meal.setMain("X-burguer");
		meal.setDrink("Coca-cola");
		meal.setDessert("Torta de limao");
		meal.setSide("left");
		meal.setToy("Relampago marquinhos");

		System.out.println(meal);
	}
}