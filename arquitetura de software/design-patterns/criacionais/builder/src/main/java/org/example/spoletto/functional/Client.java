package org.example.spoletto.functional;

import org.example.spoletto.functional.model.Pasta;
import org.example.spoletto.functional.model.Size;

public class Client {

	public static void main(String[] args) {
		Pasta p1 = new Pasta.Builder(Size.LARGE).now();
		System.out.println(p1);
		
		Pasta p2 = new Pasta.Builder(Size.SMALL)
				.withToppings("Linguica", "Macarrao")
				.withSauces("Tomate")
				.withCheese()
				.now();
		System.out.println(p2);
		
		Pasta p3 = new Pasta.Builder(Size.STANDARD)
				.withToppings("OvoFrito")
				.withSauces("Branco", "Cheese")
				.withCheese()
				.withPepper()
				.now();
		System.out.println(p3);
	}
}
