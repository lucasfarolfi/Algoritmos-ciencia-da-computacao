package org.example.spoletto.before;

import java.util.Arrays;

import org.example.spoletto.before.model.Pasta;
import org.example.spoletto.before.model.Size;

public class Client {

	public static void main(String[] args) {
		Pasta p1 = new Pasta(Size.LARGE);
		System.out.println(p1);
		
		Pasta p2 = new Pasta(Arrays.asList("Linguica", "Macarrao"), Arrays.asList("Tomato"), Size.SMALL, true);
		System.out.println(p2);
		
		Pasta p3 = new Pasta(Arrays.asList("OvoFrito"), Arrays.asList("Branco", "Cheese"), Size.STANDARD, false, true);
		System.out.println(p3);
		
	}
}
