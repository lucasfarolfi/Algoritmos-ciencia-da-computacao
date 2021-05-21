package q17;

public class Main {

	public static void main(String[] args) {

		Quadrado q1 = new Quadrado();
		Quadrado q2 = new Quadrado();
		
		q1.setAlt(3);
		q1.setLarg(5);
		
		q2.setAlt(3);
		q2.setLarg(5);
		
		System.out.println(q1.equals(q2));
		System.out.println(q2.equals(q1));
	}

}
