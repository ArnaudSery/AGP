package business;

import java.util.HashMap;
import java.util.LinkedList;

public class Excursion {

	//private static HashMap<Place,Transport> Excursions = new HashMap<Place,Transport>();
	//private Hotel hotel;
	
	private static LinkedList<Transport> ExcursionTravel = new LinkedList<Transport>();
	private static LinkedList<Place> ExcursionGroup = new LinkedList<Place>();

	
	public Excursion(LinkedList<Place> ExcursionGroup) {
		this.ExcursionGroup = ExcursionGroup;
		
		this.ExcursionTravel = choseTravel(ExcursionGroup);
	}


	//Create a list of group of places.
	public static LinkedList<LinkedList<Place>> CreateGroupPlace(LinkedList<Place> placeResult, int numberHourMax) {
		
		LinkedList<LinkedList<Place>> GroupPlace = new LinkedList<LinkedList<Place>>();
		
		LinkedList<Place> usedPlaceResult = placeResult;
		LinkedList<Place> usedPlaceResultRand = placeResult;
		
		//Create a list of list of Place
		for(int j = 0; j < 5; j++) {
			while(!usedPlaceResult.isEmpty()) {
				
				int k = 0;
				int time = 0;
				
				GroupPlace.add(new LinkedList<Place>());
				
				for(int i = 0; i < usedPlaceResult.size(); i++) {
					
					Place place = usedPlaceResult.get(i);
					time += place.getVisitDuration();
					
					if(time == numberHourMax) {
						GroupPlace.get(k).add(place);
						usedPlaceResult.remove(i);
						i--;
						break;
					}
					
					if(time < numberHourMax) {
						GroupPlace.get(k).add(place);
						usedPlaceResult.remove(i);
						i--;
					}
					else {
						time -= place.getVisitDuration();
						continue;
					}
				}
				k++;
			}
			usedPlaceResultRand = placeResult;
			
			while(!usedPlaceResultRand.isEmpty()) {
				int rand = Utilitaire.Rand(0, usedPlaceResultRand.size());
				usedPlaceResult.add(usedPlaceResultRand.get(rand));
				usedPlaceResultRand.remove(rand);
			}
			
			
			
		}
		
		return GroupPlace;
	}
	
	@SuppressWarnings("null")
	public LinkedList<Transport> choseTravel(LinkedList<Place> ExcursionGroup){
		LinkedList<Transport> ExcursionTravel = null;
		
		
		for(int i=1; i<ExcursionGroup.size();i++) {
			Place p1 = ExcursionGroup.get(i-1);
			Place p2 = ExcursionGroup.get(i);
			double distanceTraveled = Utilitaire.CalculDistance(p1.getCoordinates(), p2.getCoordinates());
			int type = Island.equals(p1, p2);
			if(type == 0) {
				ExcursionTravel.add(new Boat(distanceTraveled));
			}else {
				ExcursionTravel.add(new Bus(distanceTraveled));
			}
		}		
		return ExcursionTravel;
	}
	
	/*public static Hotel ChoseHotel(LinkedList<Hotel> placeResultHotel, LinkedList<Place> GroupPlace) {

		//This find the nearest hotel
		double min = 10000;
		Hotel choiceHotel = null;
				
		for(int i = 0; i < placeResultHotel.size(); i++) {
			
			Hotel hotel = placeResultHotel.get(i);
			double distance = 0;
			
			for(int j = 0; j < GroupPlace.size(); j++) {
			
				distance += Utilitaire.CalculDistance(hotel.getCoordinates(), GroupPlace.get(j).getCoordinates());
				
			}
			
			distance = distance / GroupPlace.size();
			
			if(min > distance) {
				min = distance;
				choiceHotel = placeResultHotel.get(i);
			}
		}
		return choiceHotel;
	}*/
	
	

	public static LinkedList<Transport> getExcursionTravel() {
		return ExcursionTravel;
	}


	public static void setExcursionTravel(LinkedList<Transport> excursionTravel) {
		ExcursionTravel = excursionTravel;
	}


	public static LinkedList<Place> getExcursionGroup() {
		return ExcursionGroup;
	}


	public static void setExcursionGroup(LinkedList<Place> excursionGroup) {
		ExcursionGroup = excursionGroup;
	}
		
}
