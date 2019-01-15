package business;

public abstract class Place {

	private int id;
	private String name;
	private int visitDuration;
	private float entrancePrice;
	private String description;
	private Coordinates coordinates;
	private Island island;
	
	
	public Place(int id, String name, int visitDuration, float entrancePrice, String description, Coordinates coordinates, Island island) {
		this.id = id;
		this.name = name;
		this.visitDuration = visitDuration;
		this.entrancePrice = entrancePrice;
		this.description = description;
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

	public int getVisitDuration() {
		return visitDuration;
	}

	public void setVisitDuration(int visitDuration) {
		this.visitDuration = visitDuration;
	}

	public float getEntrancePrice() {
		return entrancePrice;
	}

	public void setEntrancePrice(float entrancePrice) {
		this.entrancePrice = entrancePrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
