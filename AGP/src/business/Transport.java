package business;

public abstract class Transport {

	
	protected double costTransport;
	protected int type;
	protected double distanceTraveled;
	
	public Transport(){
		
	}
	
	public Transport(int type, double distanceTraveled) {
		this.type = type;
		this.distanceTraveled = distanceTraveled;
	}
	
	
	
	public double getCostTransport() {
		return costTransport;
	}

	public void setCostTransport(double costTransport) {
		this.costTransport = costTransport;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public double getDistanceTraveled() {
		return distanceTraveled;
	}

	public void setDistanceTraveled(double distanceTraveled) {
		this.distanceTraveled = distanceTraveled;
	}
	
}
