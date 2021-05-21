package excessoes;

public class Main {

	public static void main(String[] args) {

		Conta c1 = new Conta();
		int valorSaque = 1000;
		c1.depositar(100);

		System.out.println("Saldo atual: " + c1.getSaldo());
		
		try {
			c1.sacar(valorSaque);
			System.out.println("Liberando dinheiro: " + valorSaque);
		}
		catch(SemSaldoUncheckedException e){
			System.out.println(e);
		}
		
		
		System.out.println("Saldo final: " + c1.getSaldo());
		System.out.println("Fim... ");
	}

}
