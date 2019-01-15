package business;

public class Utilitaire {

	
	public static double CalculDistance(double longitudeInit, double latitudeInit, double longituteFinal, double latitudeFinal) {
		
		double distance;
		
		distance = Math.sqrt(Math.pow(longituteFinal - longitudeInit,2) + Math.pow(latitudeFinal - latitudeInit,2));
		
		return distance;
	}
	
	
	public static int ReturnTimeTransport(Coordinates hotel, Coordinates place, Transport transport) {
		
		int time = 0;
		
		double distance = CalculDistance(hotel.getLongitude(), hotel.getLongitude(), place.getLatitude(), place.getLatitude());
		
		if(transport.getType() == 1) {
			time = (int) (distance * 2);
		}
		else {
			time = (int) (distance * 1);
		}
		
		
		return time;
	}
}
