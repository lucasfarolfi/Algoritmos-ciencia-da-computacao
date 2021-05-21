package conjEIterator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class main {

	public static void main(String[] args) {

		Pessoa p1 = new Pessoa("João", "1234");
		Pessoa p2 = new Pessoa("Pedro", "4567");
		Pessoa p3 = new Pessoa("João", "1234");
		
		//Método que repete os objetos com atributos iguais
		ArrayList lista = new ArrayList();
		lista.add(p1);
		lista.add(p2);
		lista.add(p3);
		
		System.out.println(lista);
		
		//Conjuntos não repetem valores iguais
		Set conjunto = new HashSet(); //Precisa do método hashset na classe para filtrar
		conjunto.add(p1);
		conjunto.add(p2);
		conjunto.add(p3);
		
		System.out.println(conjunto);
		
		System.out.println("Media dos cpfs: " + calculaMediaCpf(conjunto));
	}
	
	public static double calculaMediaCpf(Set conjunto) {
		
		//Objeto para percorrer um conjunto ou uma lista
		Iterator it = conjunto.iterator(); //Recebe o conjunto como interator
		int somaCpf = 0;
		
		while(it.hasNext()) { //Método que procura se ainda há próximos itens na lista
			Object proximo = it.next(); //Pula para o próximo item da lista
			Pessoa p = (Pessoa)proximo;
			
			somaCpf += Integer.parseInt(p.getCpf());
		}
		return (double)somaCpf/conjunto.size();
	}

}
