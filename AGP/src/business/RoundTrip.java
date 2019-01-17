package business;

public class RoundTrip {
	
	private Hotel hotel;
	private Transport transport;
	
	public RoundTrip(Place place, Hotel hotel) {
		this.hotel = hotel;
		this.transport = transport;
	}
	
	
	
	public Hotel getHotel() {
		return hotel;
	}


	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}


	public Transport getTransport() {
		return transport;
	}


	public void setTransport(Transport transport) {
		this.transport = transport;
	}
	

}