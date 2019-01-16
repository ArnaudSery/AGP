/**
 * 
 */
package tests;

import java.util.Map;

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
		Map<String, String> tuple;
		
		for (SQLResult sqlResult : sqlResults) {
			tuple = sqlResult.getAttributes();
			
			System.out.println("========= Hotel : "
							   + tuple.get("name")
							   + " ========="
			);
			
			System.out.println("[id] "
							   + tuple.get("id")
							   + " [Price] "
							   + tuple.get("pricePerDay")
			);
		}
		
		// Islands
		sqlResults = IslandPersistence.getIslands();
		
		for (SQLResult sqlResult : sqlResults) {
			tuple = sqlResult.getAttributes();
			
			System.out.println("========= Island : "
							   + tuple.get("name")
							   + " ========="
			);
			
			System.out.println("[id] " + tuple.get("id"));
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
							   + " [Score]"
							   + mixedResult.getScore()
			);
			
			System.out.println("[Description] "
							   + mixedResult.getContent()
			);
		}
	}
}
