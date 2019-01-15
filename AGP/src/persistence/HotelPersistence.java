/**
 * 
 */
package persistence;

import java.sql.SQLException;

import persistence.extendeddb.ExtendedDatabaseAPI;
import persistence.extendeddb.jdbc.SQLResults;

/**
 *
 */
public class HotelPersistence {
	
	private HotelPersistence() {
		
	}
	
	public static SQLResults getHotels() {
		SQLResults sqlResults = null;
		ExtendedDatabaseAPI database = Database.getConnection();
		
		try {
			sqlResults = database.simpleQuery("SELECT * FROM Hotel");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sqlResults;
	}
}
