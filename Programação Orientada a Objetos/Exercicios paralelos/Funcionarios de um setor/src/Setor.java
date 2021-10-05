

public class Setor {
	String nomeSetor;
	Funcionario[] listaFunc;
	
	public double calcularFolha() {
		double totalSalario = 0.0;
		
		for(int i=0; i < listaFunc.length; i++) {
			totalSalario += listaFunc[i].salario;
		}
		
		return totalSalario;
	}
}
