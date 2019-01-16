/**
 * 
 */
package persistence;

import persistence.extendeddb.ExtendedDatabaseAPI;
import persistence.extendeddb.MixedResults;

/**
 *
 */
public class PlacePersistence {
	
	private PlacePersistence() {
		
	}
	
	public static MixedResults getPlaces(String whereClause, String withClause) {
		MixedResults mixedResults = null;
		ExtendedDatabaseAPI database = Database.getConnection();
		String query = "SELECT name, type, visitDuration, entrancePrice,"
					   + "latitude, longitude, idIsland FROM Place";
		
		if (!whereClause.isEmpty()) {
			query += " WHERE " + whereClause;
		}
		
		if (!withClause.isEmpty()) {
			query += " WITH " + withClause;
		}
		
		try {
			mixedResults = database.mixedQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mixedResults;
	}
	
	public static MixedResults getAllPlaces(String keywords) {
		return getPlaces("", keywords);
	}
	
	public static MixedResults getHistoricSites(String keywords) {
		return getPlaces("type = 'historic'", keywords);
	}
	
	public static MixedResults getActivities(String keywords) {
		return getPlaces("type = 'activity'", keywords);
	}
}
