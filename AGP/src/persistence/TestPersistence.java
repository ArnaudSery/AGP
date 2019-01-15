package persistence;

import persistence.extendeddb.MixedResult;
import persistence.extendeddb.MixedResults;
import persistence.extendeddb.jdbc.SQLResult;
import persistence.extendeddb.jdbc.SQLResults;

public class TestPersistence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SQLResults sqlResults = HotelPersistence.getHotels();
		
		for (SQLResult sqlResult : sqlResults) {
			System.out.println(sqlResult.getAttributes());
		}
		
		sqlResults = IslandPersistence.getIslands();
		
		for (SQLResult sqlResult : sqlResults) {
			System.out.println(sqlResult.getAttributes());
		}
		
		MixedResults mixedResults = PlacePersistence.getAllPlaces("rhum");
		
		for (MixedResult mixedResult : mixedResults) {
			System.out.println("========= " + mixedResult.getAttribute("name") + " =========");
			System.out.println("TYPE:" + mixedResult.getAttribute("type") + " SCORE:" + mixedResult.getScore());
			System.out.println("DESCRIPTION:" + mixedResult.getContent());
		}
	}

}
