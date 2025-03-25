package org.example.spoletto.fluent;

import org.example.spoletto.fluent.model.Pasta;
import org.example.spoletto.fluent.model.Size;
import org.example.spoletto.fluent.model.builder.PastaBuilder;

public class Client {

	public static void main(String[] args) {
		Pasta p1 = new PastaBuilder(Size.LARGE).now();
		System.out.println(p1);
		
		Pasta p2 = new PastaBuilder(Size.SMALL)
				.withToppings("Linguica", "Macarrao")
				.withSauces("Tomate")
				.withCheese()
				.now();
		System.out.println(p2);
		
		Pasta p3 = new PastaBuilder(Size.STANDARD)
				.withToppings("OvoFrito")
				.withSauces("Branco", "Cheese")
				.withCheese()
				.withPepper()
				.now();
		System.out.println(p3);
	}
}
