package equals;

public class Pessoa {
	private String nome;
	private String cpf;
	
	public Pessoa() {
		
	}
	public Pessoa(String cpf) {
		setCpf(cpf);
	}
	
	public Pessoa(String nome, String cpf) {
		setNome(nome);
		setCpf(cpf);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String toString() {
		return "["+this.cpf+"-"+this.nome+"]";
	}
	/*
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}
		if(o instanceof Pessoa) {
			Pessoa p = (Pessoa) o;
			if(this.getCpf() == p.getCpf()) {
				return true;
			}
		}
		return false;
	}
	*/
	//Método equals gerado pelo java

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	
	
}
