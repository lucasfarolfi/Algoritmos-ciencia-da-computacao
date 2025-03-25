package org.example.noSetterClass;


public class Client {
	
	public static void main(String[] args) {
		var burguerCombo = new FastFoodMeal.Builder("Fries")
				.andMain("CheeseBurguer")
				.forDrink("Coke")
				.thatsAll();
		System.out.println(burguerCombo);

		var heartAttackCombo = new FastFoodMeal.Builder("Large fries")
				.andMain("Monster Burguer")
				.forDrink("Milk Shake")
				.andDessert("Fudge Cake")
				.andGift("2 Kilograms")
				.thatsAll();
		System.out.println(heartAttackCombo);
	}
}