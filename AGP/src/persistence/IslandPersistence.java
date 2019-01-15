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
public class IslandPersistence {
	
	private IslandPersistence() {
		
	}
	
	public static SQLResults getIslands() {
		SQLResults sqlResults = null;
		ExtendedDatabaseAPI database = Database.getConnection();
		
		try {
			sqlResults = database.simpleQuery("SELECT * FROM Island");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sqlResults;
	}
}
