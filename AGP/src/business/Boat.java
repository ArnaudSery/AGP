package business;

public class Boat extends Transport {
	
	private double costTransport;

	
	public Boat() {
		super();
	}


	public Boat(double distanceTraveled) {
		super();
		this.costTransport = distanceTraveled * Constante.PRICE_BOAT;
		super.distanceTraveled = distanceTraveled * 100;
	}
}
