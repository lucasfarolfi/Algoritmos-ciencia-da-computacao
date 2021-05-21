package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class main {

	public static void main(String[] args) {

		//Collections.sort - Ordena os objetos (para comparar objetos com mais de um 
		//atributo, precisa utilizar a interface comparable
		List lista = new ArrayList();
		lista.add("Jo�o");
		lista.add("Pedro");
		lista.add("Maria");
		lista.add("Jo�o");
		
		System.out.println(lista);
		
		Collections.sort(lista);
		System.out.println(lista);
		
		//Collections.frenquency - Conta a frequ�ncia de vezes que um objeto est� na lista
		System.out.println("Frequencia: " + Collections.frequency(lista, "Jo�o"));
		
		//Collections.shuffle - Embaralha os objetos
		Collections.shuffle(lista);
		System.out.println(lista);
		
		//Collections.copy - copia os objetos de uma lista para outra
		List lista2 = new ArrayList();
		Collections.copy( lista,  lista2);
		System.out.println(lista2);
	}

}
