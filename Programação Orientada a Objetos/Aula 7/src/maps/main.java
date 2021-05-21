package maps;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import conjEIterator.Pessoa;

public class main {

	public static void main(String[] args) {

		/*O mapa é semelhante a uma lista e um conjunto, porém
		junto com o objeto armazenado, é possível passar uma key
		para poder achar o objeto mais rapido dentro da lista
		
		map.keyset() //Pega as chaves dos objetos
		
		map.values() //Pega os objetos associados as chaves
		*/

		Map mapa = new HashMap();
		
		Pessoa p = new Pessoa("Arthur", "123-4");
		p.setIdade(30);
		mapa.put(p.getCpf(), p);
		
		Pessoa p2 = new Pessoa("João", "456-4");
		p2.setIdade(25);
		mapa.put(p2.getCpf(), p2);
		
		Pessoa p3 = new Pessoa("Pedro", "678-4");
		p3.setIdade(41);
		mapa.put(p3.getCpf(), p3);
		
		System.out.println(mapa);
		
		consultaMap(mapa, "456-4");
		
		System.out.println(calculaMediaIdadeValue(mapa));
		System.out.println(calculaMediaIdadeKey(mapa));
	}
	//Consulta a pessoa dona de um CPF
	public static void consultaMap(Map m, String cpf) {
		
		Pessoa f = (Pessoa)m.get(cpf); //procura por uma pessoa com este cpf no map
		
		if(f != null) {
			System.out.println("Pessoa com este CPF: " + f);
		}
		else {
			System.out.println("Pessoa não encontrada.");
		}
	}
	
	//Calcula a média dos objetos, pegando apenas os valores dos objetos no map
	public static double calculaMediaIdadeValue(Map m) {
		Collection c = m.values();
		Iterator it = c.iterator();
		double soma = 0;
		
		while(it.hasNext()) {
			Pessoa p = (Pessoa) it.next();
			soma += p.getIdade();
		}
		return soma/c.size();
	}
	
	//Calcula a média dos objetos, pegando apenas as keys dos objetos no map
	public static double calculaMediaIdadeKey(Map m) {
		Set keys = m.keySet();
		Iterator it = keys.iterator();
		double soma = 0;
		
		while(it.hasNext()) {
			String key = (String) it.next();
			Pessoa p = (Pessoa) m.get(key);
			soma += p.getIdade();
		}
		return soma/keys.size();
	}
}
