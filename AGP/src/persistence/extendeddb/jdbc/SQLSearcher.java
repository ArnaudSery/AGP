/**
 * 
 */
package persistence.extendeddb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 */
public class SQLSearcher {
	private String url;
	private String user;
	private String password;
	private Connection jdbcConnection;
	
	
	public SQLSearcher(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}
	
	private Connection getConnection() throws SQLException {
		if (jdbcConnection == null) {
			jdbcConnection = DriverManager.getConnection(url, user, password);
		}
		
		return jdbcConnection;
	}
	
	public SQLResults search(String query) throws SQLException {
		Statement state;
		ResultSet result;
		ResultSetMetaData metaData;
		int numberAttributes;
		String attribute;
		String value;
		SQLResult tuple;
		SQLResults sqlResults;
		
		state = getConnection().createStatement();
		result = state.executeQuery(query);
		metaData = result.getMetaData();
		numberAttributes = metaData.getColumnCount();
		
		sqlResults = new SQLResults();
		
		while (result.next()) {
			tuple = new SQLResult();
			
			for (int i = 1; i <= numberAttributes; i++) {
				attribute = metaData.getColumnName(i);
				value = result.getObject(i).toString();
				
				tuple.addAttribute(attribute, value);
			}
			
			sqlResults.addTuple(tuple);
		}
		
		state.close();
		return sqlResults;
	}

	public String getUrl() {
		return url;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}
	
	public void close() throws SQLException {
		if (jdbcConnection != null) {
			jdbcConnection.close();
		}
	}
}
