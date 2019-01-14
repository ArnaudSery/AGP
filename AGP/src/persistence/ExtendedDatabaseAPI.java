/**
 * 
 */
package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import persistence.configuration.DatabaseConfiguration;

/**
 *
 */
public class ExtendedDatabaseAPI {
	private static ExtendedDatabaseAPI instance;
	private Connection jdbcConnection;
	
	
	/**
	 * Lazy Singleton
	 */
	private ExtendedDatabaseAPI() {
		
	}
	
	public static ExtendedDatabaseAPI getInstance() {
		if (instance == null) {
			instance = new ExtendedDatabaseAPI();
			
			// Initialize the JDBC connection on this instance
			instance.initializeDatabaseConnection();
		}
		
		return instance;
	}
	
	/**
	 * Establish JDBC connection
	 */
	private void initializeDatabaseConnection() {
		try {
			jdbcConnection = DriverManager.getConnection(
					DatabaseConfiguration.getUrl(),
					DatabaseConfiguration.getUser(),
					DatabaseConfiguration.getPassword());
			
		} catch (Exception e) {
			System.err.println("Connection failed : " + e.getMessage());
		}
	}
	
	public List<String> executeSQLQuery(String query) {
		return null;
	}
}
