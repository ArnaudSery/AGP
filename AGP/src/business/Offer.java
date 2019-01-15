package business;

import java.util.HashMap;
import java.util.LinkedList;

public class Offer {
	
	private int day;
	private int numberExcursion;
	private String intensity;
	private int totalCost;
	private HashMap<Integer, Excursion> planning = new HashMap<Integer, Excursion>();;
	
	public Offer(LinkedList<LinkedList<Place>> ListGroupPlace, int day, int numberExcursion, String intensity, int numberHourMax, int totalCost, boolean confort, boolean rand){
		
		this.day = day;
		this.numberExcursion = numberExcursion;
		this.intensity = intensity;
		this.totalCost = totalCost;
		
		//Choix de l'hotel au moment du 1er "put" dans planning.
		if(rand) {
			
			
			
		}else {
			int i = Utilitaire.Rand(0, numberExcursion);
			
			
		}
			
		
		
		
		int money = totalCost;
		
		for(int i = 0; i < day; i++) {
			
			
			
			// NE PAS OUBLIEZ LE PRIX
			
			
			if(numberExcursion < i /*&& money-ExcursionList.get(i).g*/) {
				planning.put(i, ExcursionList.get(i));
			}
			else {
				planning.put(i, null);
			}
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
}
