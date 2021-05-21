package br.com.lojavirtual.main;

//Importa a classe Teclado dentro do pacote br.com.lojavirtual.informatica
import br.com.lojavirtual.informatica.Teclado;

public class Teste {

	public static void main(String[] args) {
		
		//Acessa diretamente a classe teclado
		Teclado t1 = new Teclado();
		t1.setQtdTeclas(100);
		t1.setUSB(true);
		
		//Acessando a classe do package sem dar o import 
		br.com.lojavirtual.instrumentos.Teclado t2 = new br.com.lojavirtual.instrumentos.Teclado();
		t2.setQtdTeclas(80);
		t2.setUSB(false);
		
		System.out.println("Quantidade de teclas: " + t1.getQtdTeclas() + "\nTem USB: " + t1.isUSB());
		System.out.println("Quantidade de teclas: " + t2.getQtdTeclas() + "\nTem USB: " + t2.isUSB());
	}

}
