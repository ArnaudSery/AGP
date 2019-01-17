package business;

public class Visit {
		
		private Place place;
		private Transport transport;
		

		public Visit(Place placeStart, Place placeDestination) {
			
			this.place = placeDestination;
			int type = Island.equals(placeStart, placeDestination);
			
			double distanceTraveled = Utility.CalculDistance(placeStart.getCoordinates(), placeDestination.getCoordinates());
			
			if(type == 0) {
				transport = new Boat(distanceTraveled);
			}else {
				transport = new Bus(distanceTraveled);
			}
			
		}
					
					
		public Visit(Hotel hotelStart, Place placeDestination) {
			this.place = placeDestination;
			int type = Island.equals(hotelStart, placeDestination);
			
			double distanceTraveled = Utility.CalculDistance(hotelStart.getCoordinates(), placeDestination.getCoordinates());
			
			if(type == 0) {
				transport = new Boat(distanceTraveled);
			}else {
				transport = new Bus(distanceTraveled);
			}
			
		}

		public Place getPlace() {
			return place;
		}

		public void setPlace(Place place) {
			this.place = place;
		}

		public Transport getTransport() {
			return transport;
		}

		public void setTransport(Transport transport) {
			this.transport = transport;
		}
		
		
	

}