package business;

public class Hotel {
	
	private int id;
	private String name;
	private float pricePerDay;
	private Coordinates coordinates;
	private Island island;
	
	public Hotel(int id, String name, float pricePerDay, Coordinates coordinates, Island island) {
		this.id = id;
		this.name = name;
		this.pricePerDay = pricePerDay;
		this.coordinates = coordinates;
		this.island = island;
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

	public float getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(float pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public Island getIsland() {
		return island;
	}

	public void setIsland(Island island) {
		this.island = island;
	}
	
}
