package business;



public class Bus extends Transport {

	public Bus() {
		super();
	}


	public Bus(double distanceTraveled) {
		super();
		super.costTransport = distanceTraveled * Constante.PRICE_BUS;
		super.distanceTraveled = distanceTraveled * 100;
	}
}
