package test.business;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import business.ActivityPlace;
import business.Coordinates;
import business.Excursion;
import business.HistoricPlace;
import business.Hotel;
import business.Island;
import business.Place;
import business.Simulation;
import business.SimulationEntry;
import business.Utilitaire;

class BusinessTest {
	
	
	
	@Test
	void testdistance() {
		
		Coordinates coord1 = new Coordinates(14.58, 61.30);
		Coordinates coord2 = new Coordinates(14.51, 61.12);
		Coordinates coord3 = new Coordinates(-14.28, 60.58);
		Coordinates coord4 = new Coordinates(14.25,-60.50);
		Utilitaire ut = new Utilitaire();
		double distance = ut.CalculDistance(coord1.getLongitude(),coord1.getLatitude(),coord2.getLongitude(),coord2.getLatitude());
		assertTrue(distance < 0.20 && distance > 0.19);
		double distance2 = ut.CalculDistance(coord3.getLongitude(),coord3.getLatitude(),coord4.getLongitude(),coord4.getLatitude());
		assertTrue(distance2 < 125 && distance2 > 124);
	}
	
	@Test
	void testExcursion() {
		
		SimulationEntry SimulationEntry = new SimulationEntry();
	    LinkedList<Place> placeResult = new LinkedList<Place>();
		LinkedList<Hotel> placeResultHotel = new LinkedList<Hotel>();
		
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
		Place place1 = new ActivityPlace(4, "place1", 5, 150, "description", coord5, isle);
		Place place2 = new ActivityPlace(5, "place2", 2, 150, "description",coord6, isle);
		
		// 
		placeResult.add(restaurantDelArte);
		placeResult.add(TourEiffel);
		placeResult.add(place1);
		placeResult.add(place2);
		
		placeResultHotel.add(HotelDuSoldatInconnu);
		placeResultHotel.add(hotel2);
		
		Excursion.CreateExcursion(placeResult, placeResultHotel, SimulationEntry.getNumberHourMax());	
	}


}
