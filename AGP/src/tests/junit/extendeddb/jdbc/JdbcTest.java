package tests.junit.extendeddb.jdbc;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import persistence.extendeddb.jdbc.SQLResult;
import persistence.extendeddb.jdbc.SQLResults;
import persistence.extendeddb.jdbc.SQLSearcher;


class JdbcTest {

	@Test
	void testJDBC() {
		String host = "localhost";
		String base = "travelDB";
		String user = "root";
		String password = "p@ssword";
		String url = "jdbc:mysql://" + host + "/" + base;
		
		try {
			SQLSearcher searcher = new SQLSearcher(url, user, password);
			SQLResults sqlResults = searcher.search("SELECT id, name, type FROM Place");
			
			for (SQLResult sqlResult : sqlResults) {
				assertNotNull(sqlResult.getAttribute("id"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
