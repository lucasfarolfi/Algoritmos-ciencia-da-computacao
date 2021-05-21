public class teste {

	public static void main (String[] args) {
		
		Cachorro c1 = new Cachorro();
		c1.idade = 5;
		c1.nome = "Bob";
		
		System.out.println("O primeiro cachorro é o(a) " + c1.nome + " e sua idade é de " + c1.idade + " anos !!!");
		
		Cachorro c2 = new Cachorro();
		c2.idade = 10;
		c2.nome = "Nina";
		
		System.out.println("O segundo cachorro é o(a) " + c1.nome + " e sua idade é de " + c1.idade + " anos !!!");
		
		c1.latir();
		c2.latir();
	}
}
