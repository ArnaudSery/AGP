package business;



public class Bus extends Transport {

	public Bus(double distanceTraveled) {
		this.type = 1;
		this.costTransport = distanceTraveled * Constante.PRICE_BUS;
		this.distanceTraveled = distanceTraveled * 100;
	}
}
