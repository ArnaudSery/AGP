package business;

public class Boat extends Transport {

	
	public Boat() {
		super();
	}


	public Boat(double distanceTraveled) {
		super();
		super.costTransport = distanceTraveled * Constante.PRICE_BOAT;
		super.distanceTraveled = distanceTraveled * 100;
	}
	
}
