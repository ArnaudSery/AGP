package business;

import java.util.HashMap;
import java.util.LinkedList;

public class Excursion {

	private static HashMap<Place,Transport> Excursions = new HashMap<Place,Transport>();
	//private static LinkedList<Excursion> ExcursionList = new LinkedList<Excursion>();
	
	private static LinkedList<LinkedList<Place>> ExcursionGroup = new LinkedList<LinkedList<Place>>();
	
	public Excursion(HashMap<Place,Transport> Excursions) {
		this.Excursions = Excursions;
	}
	
	
	
	public static void CreateExcursion(LinkedList<Place> placeResult, LinkedList<Hotel> placeResultHotel, int numberHourMax) {
		
		
		while(!placeResult.isEmpty()) {
			
			int k = 0;
			int time = 0;
			
			ExcursionGroup.add(new LinkedList<Place>());
			
			for(int i = 0; i < placeResult.size(); i++) {
				
				Place place = placeResult.get(i);
				time += place.getVisitDuration();
				
				if(time == numberHourMax) {
					ExcursionGroup.get(k).add(place);
					break;
				}
				
				if(time < numberHourMax) {
					ExcursionGroup.get(k).add(place);
				}
				else {
					time -= place.getVisitDuration();
					continue;
				}
			}
			k++;
		}
		
		
		double min = 10000;
		Hotel choiceHotel = null;
				
		for(int i = 0; i < placeResultHotel.size(); i++) {
			
			Hotel hotel = placeResultHotel.get(i);
			double distance = 0;
			
			for(int j = 0; j < ExcursionGroup.size(); j++) {
			
				distance += Utilitaire.CalculDistance(hotel.getCoordinates(), ExcursionGroup.get(j).get(0).getCoordinates());
				
			}
			
			distance = distance / ExcursionGroup.size();
			
			if(min > distance) {
				min = distance;
				choiceHotel = placeResultHotel.get(i);
			}
		}
		
		
		
		
		
		
		/*
		double lenghtMin = 100000;
		
		Hotel currentHotel = null;
		
		
		//This loop permit to find the nearest hotel of the place who have the bigest score 
		//of the result of the search of the client
		for(int i = 0; i < placeResultHotel.size(); i++) {
			
			double currentLenght;
			double xInit = placeResultHotel.get(i).getCoordinates().getLongitude();
			double yInit = placeResultHotel.get(i).getCoordinates().getLatitude();
			double xFinal = placeResult.get(0).getCoordinates().getLongitude();
			double yFinal = placeResult.get(0).getCoordinates().getLatitude();
			currentLenght = Utilitaire.CalculDistance(xInit, yInit, xFinal, yFinal);
			
			if(lenghtMin > currentLenght) {
				currentHotel = placeResultHotel.get(i);
			}
			
		}
		
		//This loop permit to create Excursion who will be 
		
		int time = 0;
		int beginHotel = 0;
		
		
		for(int j = 0; j < placeResult.size(); j++) {
				
				
			Place place = placeResult.get(j);
				
			//Choice of Transport//
			int choiceTransport = -1;
			
			if(beginHotel == 0) {
				choiceTransport = Island.equals(currentHotel, place);
			}
			else {
				choiceTransport = Island.equals(placeResult.get(j-1), place);
			}
			
			
			Transport currentTransport;
				
			if(choiceTransport == 1) {
				currentTransport = new Bus();
			}
			else {
				currentTransport = new Boat();
			}
			///////////////////////
			
			time += Utilitaire.ReturnTimeTransport(currentHotel.getCoordinates(), place.getCoordinates(), currentTransport);
			time += place.getVisitDuration() ;
			
			
			Excursions.put(place, currentTransport);
			
			
			if((time > numberHourMax) || (j+1 == placeResult.size())) {
				Excursion ex = new Excursion(Excursions);
				ExcursionList.add(ex);
				time = 0;
				
				Excursions.clear();
				beginHotel = 0;
			}
			
			beginHotel++;
			
		}*/
		
		
	}
	
}
