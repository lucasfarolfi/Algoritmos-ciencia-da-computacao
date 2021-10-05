package exercicioFuncionarios;

public class Funcionario {
	String nome;
	int codMatricula;
	String cpf;
	String telefone;
	double salario;
	Endereco endereco;
	Dependente[] dependentes;
	
	public void imprimirDados() {
		System.out.println("Nome: " + this.nome + 
				"\nCodigo matricula: " + this.codMatricula + 
				"\nCPF: " + this.cpf
				+ "\nTelefone: " + this.telefone + 
				"\nSalario" + this.salario);
	}
	
	public void atualizarTelefone(String novoTelefone) {
		this.telefone = novoTelefone;
	}
	
	public void listaDependentes() {
		System.out.printf("Lista de dependentes:");
		for(int i=0; i < this.dependentes.length; i++) {
			System.out.printf("Dependente "+ i+1 + ": " + this.dependentes[i].cpfDependente);
		}
	}
}
