package business;

public class RoundTrip {
	
	private Hotel hotel;
	private Transport transport;

	public RoundTrip(Place placeStart, Hotel hotel) {
		
		this.hotel = hotel;
		int type = Island.equals(hotel, placeStart);
		
		double distanceTraveled = Utility.CalculDistance(placeStart.getCoordinates(), hotel.getCoordinates());
		
		if(type == 0) {
			transport = new Boat(distanceTraveled);
		}else {
			transport = new Bus(distanceTraveled);
		}
		
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