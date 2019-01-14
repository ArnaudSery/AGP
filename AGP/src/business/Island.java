package business;

public class Island {
	
	private int id;
	private String name;
	
	public Island(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	// e = earth / Bus  |  s = sea / Boat
		public int equals(Hotel hotel, Place place) {
			
			
			int choice = 0;
			
			if(hotel.getIsland().equals(place.getIsland())){
				choice = 1;
			}
			
			return choice;
		}
		
		
		public int equals(Place place1, Place place2) {
			
			int choice = 0;
			
			if(place1.getIsland().equals(place2.getIsland())){
				choice = 1;
			}
			
			return choice;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		
	
}
