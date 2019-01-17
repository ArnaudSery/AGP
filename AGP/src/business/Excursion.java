package business;

import java.util.LinkedList;

public class Excursion {

	private double price;
	private LinkedList<Visit> visits;
	private RoundTrip roundTrip;
	
	public Excursion(LinkedList<Place> placeResult, Hotel hotel) {
		
		
		this.visits = CreateVisit(placeResult, hotel);
		this.roundTrip = CreateRoundTrip(visits, hotel);
		
		this.price = CalculPriceExcursion(visits, roundTrip);
		
	}
	
	
	private double CalculPriceExcursion(LinkedList<Visit> visits, RoundTrip roundTrip) {
		double priceExcursion = 0;
		
		for(int i=0;i<visits.size();i++) {
			priceExcursion += visits.get(i).getPlace().getEntrancePrice();
			priceExcursion += visits.get(i).getTransport().getCostTransport();
		}
		
		
		priceExcursion += roundTrip.getTransport().getCostTransport();
		
		
		return priceExcursion;
	}


	public static LinkedList<Visit> CreateVisit(LinkedList<Place> placeResult, Hotel hotel) {
		
		LinkedList<Visit> visits = new LinkedList<Visit>();
		
		int time = Constante.TIME_EXCURSION;
		
			
		for(int i = 0; i < placeResult.size(); i++) {
			time -= placeResult.get(i).getVisitDuration();
			
			if(i == 0) {
				Visit visit = new Visit(hotel, placeResult.get(i));
				visits.add(visit);
			}
			else {
				if(time <= 0) {
					break;
				}
				else {
					Visit visit = new Visit(placeResult.get(i-1), placeResult.get(i));
					visits.add(visit);
				}
			}
			
			
		}
		
		
		return visits;
		
	}
	
	public static RoundTrip CreateRoundTrip(LinkedList<Visit> visits, Hotel hotel) {
		
		RoundTrip roundTrip = new RoundTrip(visits.getLast().getPlace(), hotel);
		
		return roundTrip;
		
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public LinkedList<Visit> getVisits() {
		return visits;
	}


	public void setVisits(LinkedList<Visit> visits) {
		this.visits = visits;
	}


	public RoundTrip getRoundTrip() {
		return roundTrip;
	}


	public void setRoundTrip(RoundTrip roundTrip) {
		this.roundTrip = roundTrip;
	}
	
	public String toString() {
		
		String display = "";
		
		for(int i = 0; i < visits.size(); i++){
			display += visits.get(i).toString();
			display += "\n";
		}
		
		
		display += roundTrip.toString();
		
		
		return display;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
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
		//for(int j = 0; j < ((placeResult.size()-1)*(placeResult.size()-1 * 2)); j++) {
			int k = 0;
			while(!usedPlaceResult.isEmpty()) {
				
				int time = 0;
				
				GroupPlace.add(new LinkedList<Place>());
				
				for(int i = 0; i < usedPlaceResult.size(); i++) {
					
					Place place = usedPlaceResult.get(i);
					time += place.getVisitDuration();
					
					if(time == numberHourMax) {
						GroupPlace.get(k).add(place);
						usedPlaceResult.remove(i);
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
			usedPlaceResultRand = placeResult;*/
			
			/*while(!usedPlaceResultRand.isEmpty()) {
				int rand = Utility.Rand(0, usedPlaceResultRand.size());
				usedPlaceResult.add(usedPlaceResultRand.get(rand));
				usedPlaceResultRand.remove(rand);
			}*/
			
			
			
		//}
		
	/*	return GroupPlace;
	}
	
	@SuppressWarnings("null")
	public LinkedList<Transport> choseTravel(LinkedList<Place> ExcursionGroup){
		LinkedList<Transport> ExcursionTravel = new LinkedList<Transport>();

		Transport bus = new Bus();
		Transport boat = new Boat();
		
		for(int i=1; i<ExcursionGroup.size();i++) {
			Place p1 = ExcursionGroup.get(i-1);
			Place p2 = ExcursionGroup.get(i);
			double distanceTraveled = Utility.CalculDistance(p1.getCoordinates(), p2.getCoordinates());
			int type = Island.equals(p1, p2);
			if(type == 0) {
				boat.setDistanceTraveled(distanceTraveled);
				ExcursionTravel.add(boat);
			}else {
				bus.setDistanceTraveled(distanceTraveled);
				ExcursionTravel.add(bus);
			}
		}		
		return ExcursionTravel;
	}*/
	
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
	
	

	/*public static LinkedList<Transport> getExcursionTravel() {
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
	}*/
	
	/*public static void getFirstPlace(LinkedList<Excursion> excursionList, int exNum, int plNum) {
		excursionList.get(exNum).getExcursionGroup().get(plNum);
	}*/
	
	
		
}
