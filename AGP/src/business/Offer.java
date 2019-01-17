package business;

import java.util.LinkedList;

public class Offer {
	
	private float price;
	private Hotel hotel;
	private int numberDayExcursion;
	private int day;
	private int moduloExcursion;
	private LinkedList<Excursion> excursionList = new LinkedList<Excursion>();

	public Offer(LinkedList<Place> placeResult, Hotel hotel, String intensity, int day, int priceMin, int priceMax) {
		
		
		if(intensity.compareTo("hight") == 0) {
			this.numberDayExcursion = day;
			this.moduloExcursion = Constante.MODULO_HIGHT;
		}
		else if(intensity.compareTo("medium") == 0) {
			this.numberDayExcursion = day/2;
			numberDayExcursion += day%2;
			this.moduloExcursion = Constante.MODULO_MEDIUM;
		}
		else if(intensity.compareTo("low") == 0) {
			this.numberDayExcursion = day/4;
			numberDayExcursion += day%2;
			this.moduloExcursion = Constante.MODULO_LOW;
		}
		
		this.day = day;
		
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
	

	
	public float CalculPriceOffer(LinkedList<Excursion> excursionList, Hotel hotel, int day) {
		
		float price = 0;
		double priceHotel = 0;
		
		for(int i = 0; i < excursionList.size(); i++) {
			price += excursionList.get(i).getPrice();
		}
		
		priceHotel = day * hotel.getPricePerDay();
		
		price += priceHotel;
		
		return price;
	}
	
	

	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
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
		
		String query = "\n";
		int numExcursion = 0;
		
		query+= "Prix total de l'offre : " + price + " Euros.\n=====================================================\n";
		
		for(int i = 0; i < day; i++) {
			query += "Jour : " + i + " => \n";
			query += "	|Hotel : " + hotel.getName() + ", Prix/nuit : " + hotel.getPricePerDay() + ".\n";
			
			if(i%moduloExcursion == 0) {
				query += excursionList.get(numExcursion).toString() + "\n";
				numExcursion++;
			}
			else {
				query += "	|	Plage.\n";
				query += "	|Retour : " + hotel.getName() + ", Prix/nuit : " + hotel.getPricePerDay() + ".\n\n";
			}
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
