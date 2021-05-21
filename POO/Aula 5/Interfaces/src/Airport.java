
public class Airport {

	public static void main(String[] args) {
		Airport metropolisAirport = new Airport();
		Helicopter copter = new Helicopter();
		SeaPlane sPlane = new SeaPlane();
		
		metropolisAirport.givePermitionToLand(copter);

		metropolisAirport.givePermitionToLand(sPlane);
	}
	
	private void givePermitionToLand(Flyer f) {
		f.land();
	}

}
