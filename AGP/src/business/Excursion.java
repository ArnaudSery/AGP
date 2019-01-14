package business;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class Excursion {

	private static HashMap<Place,Transport> Excursions = new HashMap<Place,Transport>();
	private int day;
	
	public Excursion() {
		
	}
	
	
	
	public static void CreateExcursion(LinkedList<Place> placeResult, LinkedList<Hotel> placeResultHotel) {
		
		double lenghtMin = 100000;
		
		for(int i = 0; i < placeResultHotel.size(); i++) {
			
			double currentLenght;
			double xInit = placeResultHotel.get(i).getCoordinates().getLongitude();
			double yInit = placeResultHotel.get(i).getCoordinates().getLatitude();
			double xFinal = placeResult.get(0).getCoordinates().getLongitude();
			double yFinal = placeResult.get(0).getCoordinates().getLatitude();
			currentLenght = Utilitaire.CalculDistance(xInit, yInit, xFinal, yFinal);
			
			if(lenghtMin > currentLenght) {
				Hotel currentHotel = placeResultHotel.get(i);
			}
			
		}
		
		while(!placeResult.isEmpty()) {
			int time = 0;
			Place p;
			for(int j = 0; j < placeResult.size(); j++) {
				//Excursions.put(placeResult.get(i),);
			}
			
				
		}
			
		
	}
	
}
