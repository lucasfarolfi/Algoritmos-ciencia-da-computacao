package equals;

public class main {

	public static void main(String[] args) {
		Pessoa p1 = new Pessoa();
		Pessoa p2 = new Pessoa();
		Pessoa p3 = new Pessoa();
		
		p1.setCpf("12345");
		p2.setCpf("12345");
		p3.setCpf("12345 ".trim());
		
		System.out.println(p1.equals(p2));
		//System.out.println(p1.equals(p3));
	}

}
