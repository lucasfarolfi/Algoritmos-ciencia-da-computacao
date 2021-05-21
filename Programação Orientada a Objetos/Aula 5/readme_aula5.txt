# Palavra reservada Final #

--> Em classes

*cria uma classe e passa ela por parâmetro

ex: Cachorro c = new Cachorro();

teste(c);

public static void teste (Animal a){}

--> Em métodos

*cria um método que não pode ser sobrescrito em nenhuma classe

ex: public final void emitirSom() { } 


--> Em variáveis

*A variável se torna uma constante

ex: public static final String DIRETORIO = 'c:/';

Obs: variáveis final são escritas em caixa alta


--> Classes abstratas

*Utiliza-se a classe abstrata para forçar as classes filhas a sobrescreverem métodos da classe pai
que é abstrata.

Obs: Quando uma classe é declarada abstrata, ela deixa de existi-la, logo não é possivel
instanciar um objeto dela mesma.

ex de classe abstrata:

classe pai-
public abstract class Animal{

	public abstract void emitirSom(); //Método que deverá ser sobrescrito
}

classe filha-
public class Abelha extends Animal{
public void emitirSom(){ System.out.println("zzzzzzz"); }
}



--> Interfaces


*todos os atributos são public, static e final

*todos os métodos devem ser ou public e abstract, não podem ser static

*para declarar uma interface:
	public interface Voador{
	}


*para declarar uma classe de uma interface:
	public class Passaro extends Animal implements Voador{
	}




--> Coleções   

*Utilizando o array para armazenar vários objetos é trabalhoso, não podemos redimensionar
o tamanho do array, é impossivel buscar diretamente dados de um objeto que não tem nome específico,
não conseguimos saber quais posições do array estão populadas

--> Listas

*Para criar um ArrayList, basta chamar o construtor:
	ArrayList lista = new ArrayList();

*É sempre possível abstrair a lista a partir da interface list:
	List lista = new ArrayList();

*ex do uso de lista:

	ContaCorrente c1 = new ContaCorrente();
	c1.deposita(100);
	ContaCorrente c2 = new ContaCorrente();
	c1.deposita(200);

	List contas = new ArrayList();
	contas.add(c1);
	contas.add(c2);

	//Para saber quantos elementos tem na lista
	System.out.println(contas.size());


*Para mostrar os atributos de todas as contas:

for(int i=0; i < contas.size(); i++){
	contas.get(i);
}


*Para mostrar algum atributo de todas as contas:

for(int i=0; i < contas.size(); i++){
	ContaCorrente cc = (ContaCorrente) contas.get(i);
	System.out.println(cc.getSaldo());
}