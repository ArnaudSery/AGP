/**
 * 
 */
package persistence;

import java.nio.file.Path;
import java.nio.file.Paths;

import persistence.extendeddb.ExtendedDatabaseAPI;
import persistence.extendeddb.SQLConfiguration;
import persistence.extendeddb.TextualConfiguration;

/**
 *
 */
public class Database {
	private static ExtendedDatabaseAPI connection;
	
	// SQL configuration
	private static String system = "mysql";
	private static String host = "localhost";
	private static String base = "travelDB";
	private static String user = "root";
	private static String password = "p@ssword";
	
	// Textual queries configuration
	private static Path sourcePath = Paths.get("C:\\Data");
	private static Path indexPath = Paths.get("C:\\Index");
	private static String table = "Place";
	private static String joinKey = "id";
	
	
	private Database() {
		
	}
	
	public static ExtendedDatabaseAPI getConnection() {
		if (connection == null) {
			SQLConfiguration sqlConfiguration = new SQLConfiguration(
					system,
					host,
					base,
					user,
					password
			);
			
			TextualConfiguration textualConfiguration = new TextualConfiguration(
					sourcePath,
					indexPath,
					table,
					joinKey
			);
			
			connection = new ExtendedDatabaseAPI(sqlConfiguration, textualConfiguration);
		}
		
		return connection;
	}
}
