

public class Endereco {
	String logradouro;
	int numero;
	String bairro;
	String cep;
	
	public void imprimirDados() {
		System.out.println("Logradouro: " + this.logradouro 
				+ "\nNumero: " + this.numero + 
				"\nBairro: " + this.bairro + "\nCEP: ");
	}
}
