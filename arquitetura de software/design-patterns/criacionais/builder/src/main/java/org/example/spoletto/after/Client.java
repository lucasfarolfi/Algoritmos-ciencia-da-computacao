package org.example.spoletto.after;

import java.util.Arrays;

import org.example.spoletto.after.model.Pasta;
import org.example.spoletto.after.model.Salad;
import org.example.spoletto.after.model.Size;
import org.example.spoletto.after.model.builder.PastaBuilder;
import org.example.spoletto.after.model.builder.SaladBuilder;

public class Client {

	public static void main(String[] args) {
		PastaBuilder pastaBuilder = new PastaBuilder();
		pastaBuilder.setSize(Size.LARGE);
		Pasta p1 = pastaBuilder.getResult();
		System.out.println(p1);
		
		SaladBuilder saladBuilder = new SaladBuilder();
		saladBuilder.setSize(Size.SMALL);
		saladBuilder.setToppings(Arrays.asList("Linguica", "Macarrao"));
		saladBuilder.setSauce(Arrays.asList("Tomate"));
		saladBuilder.setCheese(true);
		Salad p2 = saladBuilder.getResult();
		System.out.println(p2);
		
		pastaBuilder = new PastaBuilder();
		pastaBuilder.setToppings(Arrays.asList("OvoFrito"));
		pastaBuilder.setSauce(Arrays.asList("Branco", "Cheese"));
		pastaBuilder.setSize(Size.STANDARD);
		pastaBuilder.setCheese(true);
		pastaBuilder.setPepper(true);
		Pasta p3 = pastaBuilder.getResult();
		System.out.println(p3);
	}
}
