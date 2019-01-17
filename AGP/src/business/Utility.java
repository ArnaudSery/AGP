package business;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Utility {

	
	public static double CalculDistance(Coordinates Init, Coordinates Final) {
		
		double distance;
		
		double longitudeInit = Init.getLongitude(); 
		double latitudeInit = Init.getLatitude();
		double longituteFinal = Final.getLongitude();
		double latitudeFinal = Final.getLatitude();
		
		distance = Math.sqrt(Math.pow(longituteFinal - longitudeInit,2) + Math.pow(latitudeFinal - latitudeInit,2));
		
		return distance;
	}
	
	
	/*public static int ReturnTimeTransport(Coordinates hotel, Coordinates place, Transport transport) {
		
		int time = 0;
		
		double distance = CalculDistance(hotel, place);
		
		
		if(transport.getType() == 1) {
			time = (int) (distance * 2);
		}
		else {
			time = (int) (distance * 1);
		}
		
		return time;
	}*/
	
	public static LinkedList<Hotel> FindBestHotel(LinkedList<Place> placeResult, LinkedList<Hotel> hotelResult){
		LinkedList<Hotel> bestHotels = new LinkedList<Hotel>();
		Map<Integer, Integer> totalPlacesPerHotel = countPlacesPerIsland(placeResult);
		System.out.println(totalPlacesPerHotel.toString());
		int max = -1;
		int saveIndex = -1;
		
		// find the island which has the most hotels
		for (int index = 0; index < totalPlacesPerHotel.size(); index++) {
			if (max < totalPlacesPerHotel.get(index)) {
				max = totalPlacesPerHotel.get(index);
				saveIndex = index;
			}
		}
		System.out.println("max="+max);
		// add the hotel of the island which contains the most places
		for (int index = 0; index < hotelResult.size(); index++) {
			if (hotelResult.get(index).getIsland().getId() == saveIndex) {
				bestHotels.add(hotelResult.get(index));			
			}
		}
		
		
		return bestHotels;
	}
	
	public static Map<Integer, Integer> countPlacesPerIsland(LinkedList<Place> places) {
		Map<Integer, Integer> totalPlacesPerHotel = new HashMap<Integer, Integer>(); 
		int totalIsland = 3;
		
		// For each Island count the places
		for (int index = 0; index < totalIsland; index++) {
			int number = 0;
			for (Place place : places) {
				if (index == place.getIsland().getId()) {
					number++;
				}
			}
			totalPlacesPerHotel.put(index, number);
		}
		return totalPlacesPerHotel;
	}
	
	public static Hotel NearestHotel(LinkedList<Hotel> HotelList, Place place) {
		
		Hotel choiceHotel = null;
		double minDistance, distance;
		minDistance = CalculDistance(HotelList.get(0).getCoordinates(), place.getCoordinates());
		
		for(int i = 0; i < HotelList.size(); i++) {
			
			distance = CalculDistance(HotelList.get(i).getCoordinates(), place.getCoordinates());
			
			if(minDistance > distance) {
				minDistance = distance;
				choiceHotel = HotelList.get(i);
			}
			
		}
		
		
		return choiceHotel;
	}
	
	
	public static int Rand(int i, int j) {
		Random rnd = new Random();
		int number = i + rnd.nextInt(j - i + 1);
		return number;
	}
	
	public static void toString(String query) {
		System.out.println(query);
	}
}
