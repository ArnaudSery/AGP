package beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import business.Hotel;
import business.Place;
import business.SimulationEntry;
/**
 * 
 * @author Archambault Vincent
 *
 */

@ManagedBean
@SessionScoped
public class EntryBean {
	private SimulationEntry entry = new SimulationEntry();
	private List<Hotel> hotels=new LinkedList<Hotel>();
	
	public EntryBean() {
	}
	public String getKeyword() {
		return entry.getKeyWord();
	}
	public void setKeyword(String keyword) {
		entry.setKeyWord(keyword);
	}
	public SimulationEntry getEntry() {
		return entry;
	}
	public void setEntry(SimulationEntry entry) {
		this.entry = entry;
	}
	public int getNumberDay() {
		return entry.getNumberDay();
	}
	public void setNumberDay(int numberDay) {
		entry.setNumberDay(numberDay);
	}
	public String getType() {
		return entry.getTypeVisit();
	}
	public void setType(String type) {
		entry.setTypeVisit(type);
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
	public int getPriceMin() {
		return entry.getPriceMin();
	}
	public void setPriceMin(int priceMin) {
		entry.setPriceMin(priceMin);
	}
	public int getPriceMax() {
		return entry.getPriceMax();
	}
	public void setPriceMax(int priceMax) {
		 entry.setPriceMax(priceMax);
	}
	public String getIntensity() {
		return entry.getIntensity();
	}
	public void setIntensity(String intensity) {
		entry.setIntensity(intensity);
	}

	public String Simulation() {
		String sim="";
		return sim;
	}
	
	public String QueryHotel(){
		
		
		return "result";
	}
	
	public List<Place> QueryActivity(){
		List<Place> place = new LinkedList<Place>();
		
		return place;
	}
	
}
