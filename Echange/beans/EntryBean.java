package beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import business.Offer;
import business.Place;
import business.tools.OffersBuilder;
import business.tools.UserPreferences;
import persistence.PlacePersistence;

/**
 * 
 * @author Archambault Vincent
 *
 */

@ManagedBean
@SessionScoped
public class EntryBean {

	public UserPreferences getUser() {
		return user;
	}

	public void setUser(UserPreferences user) {
		this.user = user;
	}

	private UserPreferences user= new UserPreferences();
	public double getTransport() {
		return user.getMaximumTransportDuration();
	}

	public void setTransport(double transport) {
		user.setMaximumTransportDuration(transport);
	}

	private String intensity;
	private List<Place> place=new LinkedList<Place>(); 
	private List<Offer> offer = new LinkedList<Offer>();
	private Offer firstoffer;
	


	public Offer getFirstoffer() {
		return firstoffer;
	}

	public void setFirstoffer(Offer firstoffer) {
		this.firstoffer = firstoffer;
	}

	public String startOffer() {
		int exurcionintensity=0;
		if(intensity.equals("faible"))
			exurcionintensity=1;
		else if(intensity.equals("moyen"))
			exurcionintensity=2;
		else {
			exurcionintensity=3;		}
		user.setExcursionsFrequency(exurcionintensity);
		OffersBuilder build = new OffersBuilder(user);
		offer=build.buildOffers();

		if(!offer.isEmpty()) {
		firstoffer=offer.get(0);
			return "offer";
		}
		else {
			return "error";
		}
    }
	
	public String startSimulation() {
		if(user.getPlaceType().equals("historic")) {
			place=PlacePersistence.getHistoricPlaces(getKeyWord());
			System.out.println(place.size());
		}
		else if(user.getPlaceType().equals("activity")) {
			place=PlacePersistence.getActivityPlaces(getKeyWord());
			System.out.println(place.size());
		}
		else {
			place=PlacePersistence.getPlaces(getKeyWord());
			System.out.println(place);
		}
		return "result";
    }
	
	public EntryBean() {
	}

	
	public List<SelectItem> getTypes(){
		List<SelectItem> items = new ArrayList<SelectItem>();
		LinkedList<String> types = new LinkedList<String>();
		types.add("all");
		types.add("historic");
		types.add("activity");
		Iterator<String> supportedLocales = types.iterator();
		while (supportedLocales.hasNext()) {
		String type  = supportedLocales.next();	
			items.add(new SelectItem(type,type));
		}
		return items;
	}
	public List<SelectItem> getIntensities(){

		List<SelectItem> items = new ArrayList<SelectItem>();
		LinkedList<String> intensities = new LinkedList<String>();
		intensities.add("faible");
		intensities.add("moyenne");
		intensities.add("fort");
		Iterator<String> supportedLocales = intensities.iterator();
		while (supportedLocales.hasNext()) {
		String type  = supportedLocales.next();	
			items.add(new SelectItem(type,type));
		}
		return items;
	}



	public String getKeyWord() {
		return user.getKeywords();
	}


	public void setKeyWord(String keyWord) {
		user.setKeywords(keyWord);
	}


	public int getNumberDay() {
		return user.getNumberOfDays();
	}


	public void setNumberDay(int numberDay) {
		user.setNumberOfDays(numberDay);
	}


	public String getType() {
		return user.getPlaceType();
	}


	public void setType(String type) {
		user.setPlaceType(type);
	}


	public int getPriceMin() {
		return user.getMinimumPrice();
	}


	public void setPriceMin(int priceMin) {
		user.setMinimumPrice(priceMin);
	}


	public int getPriceMax() {
		return user.getMaximumPrice();
	}


	public void setPriceMax(int priceMax) {
		user.setMaximumPrice(priceMax);
	}


	public String getIntensity() {
		return intensity;
	}


	public void setIntensity(String intensity) {
		this.intensity = intensity;
	}




	public List<Place> getPlace() {
		return place;
	}


	public void setPlace(List<Place> place) {
		this.place = place;
	}
	
	public List<Offer> getOffer() {
		return offer;
	}

	public void setOffer(List<Offer> offer) {
		this.offer = offer;
	}

}
