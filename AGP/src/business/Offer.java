package business;

import java.util.HashMap;
import java.util.LinkedList;

public class Offer {
	
	private int day;
	private int numberExcursion;
	private String intensity;
	private int totalCost;
	private Hotel hotel;
	private HashMap<Integer, Excursion> planning = new HashMap<Integer, Excursion>();;
	
	public Offer(LinkedList<Excursion> ExcursionList, int day, int numberExcursion, String intensity, int numberHourMax, int totalCost, boolean confort, boolean rand){
		
		this.day = day;
		this.numberExcursion = numberExcursion;
		this.intensity = intensity;
		this.totalCost = totalCost;
		
		int pause = day - numberExcursion;
		
		//Choix de l'hotel au moment du 1er "put" dans planning.
		if(rand) {
			
			int randomDayExcursion;
			int randomExcursion;
			
			for(int j = 0; j < numberExcursion; j++) {
				
				randomDayExcursion = Utility.Rand(0, day);
				randomExcursion = Utility.Rand(0, ExcursionList.size());
				
				if(planning.get(randomDayExcursion).equals(null)){
					planning.put(randomDayExcursion, ExcursionList.get(randomExcursion));
				}
			}
			
			for(int j = 0; j < day; j++) {
				
				if(planning.get(j).equals(null)){
					planning.put(j, null);
				}
			}
		}
		
		
		
		
		else {
			
			int randomPause;
			int numExcursion = numberExcursion;
			
			for(int j = 0; j < day; j++) {
				
				randomPause = Utility.Rand(0, 3);
				
				if(numberExcursion == day) {
					planning.put(j, ExcursionList.get(j));
				}
				if(pause == day) {
					planning.put(j, null);
				}
				
				if((randomPause == 0 || numExcursion == 0) && pause > 0) {
					numExcursion--;
					pause--;
					planning.put(j, null);
				}
				else {
					numExcursion--;
					planning.put(j, ExcursionList.get(j));
				}
			}
		}
			
		
		
		/*
		int money = totalCost;
		
		for(int i = 0; i < day; i++) {*/
			
			
			
			// NE PAS OUBLIEZ LE PRIX
			
			
			/*if(numberExcursion < i /*&& money-ExcursionList.get(i).g) {*/
				/*planning.put(i, ExcursionList.get(i));
			}
			else {
				planning.put(i, null);
			}
		}
		*/
		
		
		
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getNumberExcursion() {
		return numberExcursion;
	}

	public void setNumberExcursion(int numberExcursion) {
		this.numberExcursion = numberExcursion;
	}

	public String getIntensity() {
		return intensity;
	}

	public void setIntensity(String intensity) {
		this.intensity = intensity;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	public HashMap<Integer, Excursion> getPlanning() {
		return planning;
	}

	public void setPlanning(HashMap<Integer, Excursion> planning) {
		this.planning = planning;
	}
	
	
	
	
	
	
	
	
	
	
	
}
