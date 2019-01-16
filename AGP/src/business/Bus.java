package business;



public class Bus extends Transport {
	
	private double costTransport;

	
	public Bus() {
		super();
	}


	public Bus(double distanceTraveled) {
		super();
		this.costTransport = distanceTraveled * Constante.PRICE_BUS;
		super.distanceTraveled = distanceTraveled * 100;
	}
}
