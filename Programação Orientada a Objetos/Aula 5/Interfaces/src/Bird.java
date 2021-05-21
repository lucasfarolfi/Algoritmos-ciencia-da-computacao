
public class Bird extends Animal implements Flyer{

	@Override
	public void takeOff() {
		System.out.println("Levantando voo...");
		
	}

	@Override
	public void land() {
		System.out.println("Pousando...");
		
	}

	@Override
	public void fly() {
		System.out.println("Voando");
		
	}

	public void buildNest() {
		System.out.println("Construindo ninho...");
	}
}
