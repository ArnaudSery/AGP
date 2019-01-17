package business;

import java.util.LinkedList;

public class Simulation {
	
	private SimulationEntry simulationEntry = new SimulationEntry();
	private LinkedList<Place> placeResult = new LinkedList<Place>();
	private LinkedList<Hotel> placeResultHotel = new LinkedList<Hotel>();
	private LinkedList<Offer> offerList = new LinkedList<Offer>();
	//private LinkedList<Excursion> excursionList = new LinkedList<Excursion>();
	
	public Simulation() {
		
	}
	
	public void simulate() {
		Coordinates coord1 = new Coordinates(14.58, 61.30);
		Coordinates coord2 = new Coordinates(14.51, 61.12);
		Coordinates coord3 = new Coordinates(14.28, 60.58);
		Coordinates coord4 = new Coordinates(14.25,60.50);
		Coordinates coord5 = new Coordinates(14.23,60.52);
		Coordinates coord6 = new Coordinates(14.26,60.50);
		Island isle = new Island(0, "Guadeloupe");
		Hotel HotelDuSoldatInconnu = new Hotel(0, "HotelDuSoldatInconnu", 200, coord1, isle);
		Place restaurantDelArte = new HistoricPlace(1, "DelArte", 2, 100, "husihvgriuh", coord2, isle);
		Place TourEiffel = new HistoricPlace(2, "TourEiffel", 6, 100, "husihvgriuh", coord3, isle);
		Hotel hotel2 = new Hotel(3, "hotel2", 150, coord4, isle);
		Place place1 = new ActivityPlace(4, "place1", 5, 150, "lol", coord5, isle);
		Place place2 = new ActivityPlace(5, "place2", 2, 150, "lol",coord6, isle);
		
		
		placeResult.add(restaurantDelArte);
		placeResult.add(TourEiffel);
		placeResult.add(place1);
		placeResult.add(place2);
		
		placeResultHotel.add(HotelDuSoldatInconnu);
		placeResultHotel.add(hotel2);
		
		
		LinkedList<Hotel> bestHotel = Utility.FindBestHotel(placeResult, placeResultHotel);
		
		
		for(int i = 0; i < 3; i++) {
			Offer offer = new Offer(placeResult, bestHotel.get(i), simulationEntry.getNumberDayExcursion());
			offerList.add(offer);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		//Excursion.CreateExcursion(placeResult, placeResultHotel, SimulationEntry.getNumberHourMax());
		
		LinkedList<LinkedList<Place>> ListGroupPlace = Excursion.CreateGroupPlace(placeResult,SimulationEntry.getNumberHourMax());
		SimulationEntry.getNumberDay();
		SimulationEntry.getNumberExcursion();
		
		
		//EXCEPTION SI AUCUN PLACE DANS PLACERESULT
		
		for(int i = 0; i < ListGroupPlace.size(); i++) {
			excursionList.add(new Excursion(ListGroupPlace.get(i)));
		}
		
		for(int i = 0; i < 10; i++) {
			Offer offer = new Offer(excursionList, placeResultHotel, SimulationEntry.getNumberDay(), SimulationEntry.getNumberExcursion(), SimulationEntry.getIntensity(), SimulationEntry.getNumberHourMax(), SimulationEntry.getTotalCost(), SimulationEntry.isConfort(), false);
			OfferList.add(offer);
			System.out.println("Offre " + i + ":");
			System.out.println("Hotel " + offer.getHotel().getName() + ":");
		}*/
		/*for(int i = 0; i < SimulationEntry.getNumberDay(); i++) {
			Offer offre = new Offer(placeResult, SimulationEntry.getNumberDay(), SimulationEntry.getNumberExcursion(), SimulationEntry.getIntensity(), SimulationEntry.getNumberHourMax(), SimulationEntry.getTotalCost(), SimulationEntry.isConfort());
			OfferList.add(offre);
		}*/
		
		
		
	}
	

}
