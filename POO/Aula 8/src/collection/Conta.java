package collection;

public class Conta implements Comparable<Conta>{
	private double saldo;
	private String cpf;
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public int compareTo(Conta o) {
		return cpf.compareTo(o.cpf); //Compara um CPF com o outro
	}
}
