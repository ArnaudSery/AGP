package business;

public class Visit {
		
		private Place place;
		private Transport transport;
		
		public Visit(Hotel place1, Place place2) {
			this.place = place1;
			this.transport = ;
		}
		
		public Visit(Place place1, Place place2) {
			this.place = place;
			this.transport = ;
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