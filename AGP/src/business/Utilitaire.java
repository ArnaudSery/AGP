package business;

public class Utilitaire {

	
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
}
