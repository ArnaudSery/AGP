package business;

import java.util.LinkedList;
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
	
	
	public static int ReturnTimeTransport(Coordinates hotel, Coordinates place, Transport transport) {
		
		int time = 0;
		
		double distance = CalculDistance(hotel, place);
		
		if(transport.getType() == 1) {
			time = (int) (distance * 2);
		}
		else {
			time = (int) (distance * 1);
		}
		
		return time;
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
}
