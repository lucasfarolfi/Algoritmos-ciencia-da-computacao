package exercicioFuncionarios;

public class main {

	public static void main(String[] args) {
		
		//Endereço de um usuário
		Endereco e1 = new Endereco();
		e1.logradouro = "Rua Canabarro";
		e1.numero = 550;
		e1.bairro = "Tijuca";
		e1.cep = "55500100";
		
		Endereco e2 = new Endereco();
		e2.logradouro = "Praia do Flamengo";
		e2.numero = 10;
		e2.bairro = "Flamengo";
		e2.cep = "78952100";
		
		//Dependentes de um usuário
		Dependente d1 = new Dependente();
		Dependente d2 = new Dependente();
		Dependente d3 = new Dependente();
		Dependente d4 = new Dependente();
		
		d1.cpfDependente = "234.234.234-23";
		d2.cpfDependente = "456.456.456-45";
		d3.cpfDependente = "678.678.678-67";
		d4.cpfDependente = "789.789.789-78";
		
		//Funcionarios
		Funcionario f1 = new Funcionario();
		f1.nome = "João";
		f1.codMatricula = 123;
		f1.cpf = "123.123.123-12";
		f1.telefone = "93485-2342";
		f1.salario = 1599.99;
		
		f1.endereco = new Endereco();
		f1.endereco = e1;
		f1.dependentes = new Dependente[2];
		f1.dependentes[0] = d1;
		f1.dependentes[1] = d2;
		
		Funcionario f2 = new Funcionario();
		f2.nome = "Pedro";
		f2.codMatricula = 345;
		f2.cpf = "235.235.235-34";
		f2.telefone = "93485-4567";
		f2.salario = 1000.99;
		
		f2.endereco = new Endereco();
		f2.endereco = e2;
		f2.dependentes = new Dependente[2];
		f2.dependentes[0] = d3;
		f2.dependentes[1] = d4;
		
		//Setor
		Setor setor1 = new Setor();
		setor1.listaFunc = new Funcionario[2];
		setor1.listaFunc[0] = f1;
		setor1.listaFunc[1] = f2;
		
		
		System.out.println("Total dos salários do setor:" + setor1.calcularFolha());
	}

}
