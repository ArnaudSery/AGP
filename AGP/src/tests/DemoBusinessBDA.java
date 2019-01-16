/**
 * 
 */
package tests;

import persistence.HotelPersistence;
import persistence.IslandPersistence;
import persistence.PlacePersistence;
import persistence.extendeddb.MixedResult;
import persistence.extendeddb.MixedResults;
import persistence.extendeddb.jdbc.SQLResult;
import persistence.extendeddb.jdbc.SQLResults;

/**
 *
 */
public class DemoBusinessBDA {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Hotels
		SQLResults sqlResults = HotelPersistence.getHotels();
		
		for (SQLResult tuple : sqlResults) {
			System.out.println("========= Hotel : "
							   + tuple.getAttribute("name")
							   + " ========="
			);
			
			System.out.println("[id] "
							   + tuple.getAttribute("id")
							   + " [Price] "
							   + tuple.getAttribute("pricePerDay")
			);
		}
		
		// Islands
		sqlResults = IslandPersistence.getIslands();
		
		for (SQLResult tuple : sqlResults) {
			System.out.println("========= Island : "
							   + tuple.getAttribute("name")
							   + " ========="
			);
			
			System.out.println("[id] " + tuple.getAttribute("id"));
		}
		
		// Places
		MixedResults mixedResults = PlacePersistence.getAllPlaces("rhum");
		
		for (MixedResult mixedResult : mixedResults) {
			System.out.println("========= Place : "
							   + mixedResult.getAttribute("name")
							   + " ========="
			);
			
			System.out.println("[Type] "
							   + mixedResult.getAttribute("type")
							   + " [Score] "
							   + mixedResult.getScore()
			);
			
			System.out.println("[Description] "
							   + mixedResult.getContent()
			);
		}
	}
}
