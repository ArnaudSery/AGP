package business;

public abstract class Transport {

	
	protected int costTransport;
	protected int type;
	
	public Transport(){
		
	}
	
	public Transport(int costTransport, int type) {
		this.costTransport = costTransport;
		this.type = type;
	}
	
	
	
	public int getCostTransport() {
		return costTransport;
	}

	public void setCostTransport(int costTransport) {
		this.costTransport = costTransport;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}
