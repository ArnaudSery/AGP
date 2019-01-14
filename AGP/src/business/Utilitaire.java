package business;

public class Utilitaire {

	
	public static double CalculDistance(double longitudeInit, double latitudeInit, double longituteFinal, double latitudeFinal) {
		
		double distance;
		
		distance = Math.sqrt(Math.pow(longituteFinal - longitudeInit,2) + Math.pow(latitudeFinal - latitudeInit,2));
		
		return distance;
	}
}
