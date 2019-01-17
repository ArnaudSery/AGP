package business;

public abstract class Transport {

	protected double distanceTraveled;
	protected double costTransport;
	
	public Transport(){
		
	}

	public double getDistanceTraveled() {
		return distanceTraveled;
	}

	public void setDistanceTraveled(double distanceTraveled) {
		this.distanceTraveled = distanceTraveled;
	}
	
	public double getCostTransport() {
		return costTransport;
	}


	public void setCostTransport(double costTransport) {
		this.costTransport = costTransport;
	}
	
}
