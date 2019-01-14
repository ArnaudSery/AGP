package business;

import java.util.HashMap;

public class Simulation {
	
	private SimulationEntry SimulationEntry;
	private HashMap<Places, Integer> placeResult = new HashMap<Places, Integer>();
	
	public Simulation() {
		
	}
	
	public void simulate() {
		Coordinates coord1 = new Coordinates(14.58, 61.30);
		Coordinates coord2 = new Coordinates(14.51, 61.12);
		Coordinates coord3 = new Coordinates(14.28, 60.58);
		Coordinates coord4 = new Coordinates(14.25,60.50);
		Coordinates coord5 = new Coordinates(14.23,60.52);
		Coordinates coord6 = new Coordinates(14.26,60.50);
		Island isle = new Island(0, "Guadeloupe");
		Hotel HotelDuSoldatInconnu = new Hotel(0, "HotelDuSoldatInconnu", 200, coord1, isle);
		Places restaurantDelArte = new HistoricPlace(1, "DelArte", 2, 100, "husihvgriuh", coord2, isle);
		Places TourEiffel = new HistoricPlace(2, "TourEiffel", 6, 100, "husihvgriuh", coord3, isle);
		Hotel hotel2 = new Hotel(3, "hotel2", 150, coord4, isle);
		Places place1 = new ActivityPlace(4, "place1", 5, 150, "lol", coord5, isle);
		Places place2 = new ActivityPlace(5, "place2", 2, 150, "lol",coord6, isle);
		
		// 
		placeResult.put(key, value)
		
		
		
		
		
		
	}

}
