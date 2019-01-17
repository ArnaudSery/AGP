package business;

import java.util.LinkedList;

public class Offer {
	
	private double price;
	private Hotel hotel;
	private LinkedList<Excursion> excursionList = new LinkedList<Excursion>();
	
	public Offer(LinkedList<Place> placeResult, Hotel hotel, int numberDayExcursion, int day) {
		
		this.hotel = hotel;
		
		this.excursionList = CreateOffer(placeResult, hotel, numberDayExcursion);
		
		this.price = CalculPriceOffer(excursionList, hotel, day);
	}
	
	
	public static LinkedList<Excursion> CreateOffer(LinkedList<Place> placeResult, Hotel hotel, int numberDayExcursion) {
		
		LinkedList<Excursion> excursions = new LinkedList<Excursion>();
		
		for(int i = 0; i < numberDayExcursion; i++) {
			Excursion excursion = new Excursion(placeResult, hotel);
			excursions.add(excursion);
		}
		
		return excursions;
	}
	

	
	public double CalculPriceOffer(LinkedList<Excursion> excursionList, Hotel hotel, int day) {
		
		double price = 0;
		double priceHotel = 0;
		
		for(int i = 0; i < excursionList.size(); i++) {
			price += excursionList.get(i).getPrice();
		}
		
		priceHotel = day * hotel.getPricePerDay();
		
		price += priceHotel;
		
		return price;
	}
	
	

	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Hotel getHotel() {
		return hotel;
	}


	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}


	public LinkedList<Excursion> getExcursionList() {
		return excursionList;
	}


	public void setExcursionList(LinkedList<Excursion> excursionList) {
		this.excursionList = excursionList;
	}
	
	
	public String toString() {
		String query = "";
		
		query+= "Prix total de l'offre : " + this.price + "\n" +
				"Hotel : " + this.hotel.getName() + ", Prix/nuit : " + this.hotel.getPricePerDay() + "\n";
		
		for(int i=0;i<this.excursionList.size();i++) {
			query += this.excursionList.get(i).toString();
		}
			
		return query;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*private int day;
	private int numberExcursion;
	private String intensity;
	private int totalCost;
	private Hotel hotel;
	private HashMap<Integer, Excursion> planning = new HashMap<Integer, Excursion>();;
	
	public Offer(LinkedList<Excursion> ExcursionList, LinkedList<Hotel> hotelList, int day, int numberExcursion, String intensity, int numberHourMax, int totalCost, boolean confort, boolean rand){
		
		this.day = day;
		this.numberExcursion = numberExcursion;
		this.intensity = intensity;
		this.totalCost = totalCost;
		
		int pause = day - numberExcursion;
		int first = 0;
		
		
		//////////int money = totalCost;////////
		
		//PRENDRE EN COMPTE LE PRIX QUE LA PERSONNE PEUT METTRE DANS SON VOYAGE
		
		if(rand) {
			
			int randomDayExcursion;
			int randomExcursion;
			
			for(int j = 0; j < numberExcursion; j++) {
				
				randomDayExcursion = Utility.Rand(0, day);
				randomExcursion = Utility.Rand(0, ExcursionList.size());
				
				if(planning.get(randomDayExcursion).equals(null)){
					planning.put(randomDayExcursion, ExcursionList.get(randomExcursion));
					if(first == 0) {
						Place firstPlace = ExcursionList.get(randomExcursion).getExcursionGroup().get(0);
						this.hotel = Utility.NearestHotel(hotelList, firstPlace);
						first++;
					}
				}
			}
			
			for(int j = 0; j < day; j++) {
				if(planning.get(j).equals(null)){
					planning.put(j, null);
				}
			}
		}
		
		
		else {
			
			first = 0;
			
			int randomPause;
			int numExcursion = numberExcursion;
			
			for(int j = 0; j < day; j++) {
				
				randomPause = Utility.Rand(0, 3);
				
				if(numberExcursion == day) {
					planning.put(j, ExcursionList.get(j));
					if(first == 0) {
						Place firstPlace = ExcursionList.get(j).getExcursionGroup().get(0);
						this.hotel = Utility.NearestHotel(hotelList, firstPlace);
						first++;
					}
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
					if(first == 0) {
						Place firstPlace = ExcursionList.get(j).getExcursionGroup().get(0);
						this.hotel = Utility.NearestHotel(hotelList, firstPlace);
						first++;
					}
				}
			}
		}
	}
	
	

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
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
	}*/
	
}
