package business;

public class Coordinates {

	private double longitude;
	private double latitude;
	
	public Coordinates(double longitude, double latitude) {
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public double CalculDistance(double longitudeInit, double latitudeInit, double longituteFinal, double latitudeFinal) {
		
		double distance;
		
		distance = Math.sqrt(Math.pow(longituteFinal - longitudeInit,2) + Math.pow(latitudeFinal - latitudeInit,2));
		
		return distance;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	
}
