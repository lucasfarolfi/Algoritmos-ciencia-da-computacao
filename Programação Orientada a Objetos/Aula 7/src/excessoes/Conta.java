package excessoes;

public class Conta {
	private double saldo;
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void sacar(double valor) {
		if(this.saldo < valor) {
			
			throw new SemSaldoUncheckedException("Tentando sacar: " + valor + " - Saldo: " + this.saldo);
		}
		else {
			this.saldo -= valor;
		}
	}
	
	public void depositar(double valor) {
		saldo += valor;
	}
}
