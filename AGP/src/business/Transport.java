package business;

public abstract class Transport {

	
	public int costTransport;

	public Transport() {
		
	}
	
	public Transport(int costTransport) {
		this.costTransport = costTransport;
	}
	
	public int getCostTransport() {
		return costTransport;
	}

	public void setCostTransport(int costTransport) {
		this.costTransport = costTransport;
	}
	
}
