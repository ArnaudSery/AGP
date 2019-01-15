package business;

public class Boat extends Transport {

	public Boat(double distanceTraveled) {
		this.type = 0;
		this.costTransport = distanceTraveled * Constante.PRICE_BOAT;
		this.distanceTraveled = distanceTraveled * 100;
	}
}
