package org.example.fluent;


public class Client {
	
	public static void main(String[] args) {
		var burguerCombo = new FastFoodMealBuilder("Fries")
				.andMain("CheeseBurguer")
				.forDrink("Coke")
				.thatsAll();
		System.out.println(burguerCombo);

		var heartAttackCombo = new FastFoodMealBuilder("Large fries")
				.andMain("Monster Burguer")
				.forDrink("Milk Shake")
				.andDessert("Fudge Cake")
				.andGift("2 Kilograms")
				.thatsAll();
		System.out.println(heartAttackCombo);
	}
}