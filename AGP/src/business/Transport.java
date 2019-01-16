package business;

public abstract class Transport {

	protected double distanceTraveled;
	
	public Transport(){
		
	}
	
	public Transport(double distanceTraveled) {
		this.distanceTraveled = distanceTraveled;
	}
	
	

	public double getDistanceTraveled() {
		return distanceTraveled;
	}

	public void setDistanceTraveled(double distanceTraveled) {
		this.distanceTraveled = distanceTraveled;
	}
	
}
