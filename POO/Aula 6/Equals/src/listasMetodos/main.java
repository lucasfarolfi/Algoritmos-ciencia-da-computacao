package listasMetodos;

import java.util.ArrayList;
import java.util.List;

import equals.Pessoa;

public class main {

	public static void main(String[] args) {
		/* 
			
			List.get(int): Object //pega o toString do objeto
			List.add(Object): boolean //adiciona um array
			List.indexOf(Object): int //Pega a posição do array que o objeto está na lista
			List.remove(int): Object 
			List.remove(Object): boolean //Remove o objeto da lista
			List.contains(Object): boolean //Verifica se contém este objeto na lista
			List.removeAll(Collection) : boolean //Remove tudo da lista
		*/
		
		//Lista do banco de dados original
		List lista = getPessoasDoBancoDeDados();
		//System.out.println(lista);
		
		//Lista do metodo get
		List lista2 = getPessoas();
		//System.out.println(lista2);
		
		//Lista do indexof
		String consultaCpf = "345457";
		Pessoa consultaPessoa = new Pessoa(consultaCpf);
		
		int indice = -1;
		List lista3 = getPessoas();
		
		System.out.println(lista3);
		indice = lista3.indexOf(consultaPessoa);
		System.out.println("Indice: " + indice);
		
		//Metodo contains
		System.out.println("Contains: " + lista3.contains(consultaPessoa));
		
		//Metodo remove
		System.out.println("Contains: " + lista3.remove(consultaPessoa));
	}
	
	//Método get
	public static List getPessoas() {
		ArrayList a = new ArrayList();
		
		List bd = getPessoasDoBancoDeDados();
		
		for(int i = 0; i < bd.size(); i++) {
			String pessoastring = (String) bd.get(i); //Faz casting em um objeto do array de pessoas
			String [] dados_pessoa = pessoastring.split("#"); //Quebra o array em 2 onde tem #
			
			Pessoa p = new Pessoa(dados_pessoa[0], dados_pessoa[1]); //O primeiro é o nome e o segundo é o CPF
		
			a.add(p);
		}
		return a;
	}
	
	// Método de adicionar
	public static List getPessoasDoBancoDeDados() {
		ArrayList pessoas = new ArrayList();
		pessoas.add("Lucas#12345");
		pessoas.add("João#345457");
		pessoas.add("Pedro#694850");
		
		return pessoas;
	}

}
