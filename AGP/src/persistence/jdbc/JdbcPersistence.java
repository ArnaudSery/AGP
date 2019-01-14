package persistence.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcPersistence implements APIPersistence {
	private  static String host = "localhost";
	private  static String base = "travelDB";
	private  static String user = "root";
	private  static String password = "";
	private  static String url = "jdbc:mysql://" + host + "/" + base;
	
	private Connection connection;
	
	public JdbcPersistence() {
		prepareConnection();
	}
	
	private void prepareConnection() {
		if (connection == null) {
			try {
				connection = DriverManager.getConnection(url, user, password);
			} catch (Exception e) {
				System.err.println("Connection failed : " + e.getMessage());
			}
		}
	}
	
	public String treatQuery(String stringQuery) {
		String resultQuery;
		
		if(isNormalQuery(stringQuery)) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(stringQuery);
				preparedStatement.setString(1, stringQuery);
				
				ResultSet result = preparedStatement.executeQuery();
				
				result.next();
				// affect the result of the first column of the query
				resultQuery = result.getString(1);
				return resultQuery;
			} catch (SQLException se) {
				System.err.println(se.getMessage());
			}
		} else {
			// split the query for the WITH keyword
		}
		return null;
	}
	
	public boolean isNormalQuery(String stringQuery) {
		String keyWord = " with";
		
		return (stringQuery.toLowerCase().indexOf(keyWord) > -1 ? true : false);
	}
}

