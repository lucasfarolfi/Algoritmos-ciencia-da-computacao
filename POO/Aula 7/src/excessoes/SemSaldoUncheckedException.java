package excessoes;

public class SemSaldoUncheckedException extends RuntimeException{

	public SemSaldoUncheckedException() {
		
	}
	public SemSaldoUncheckedException(String msg) {
		super(msg);
	}
}
