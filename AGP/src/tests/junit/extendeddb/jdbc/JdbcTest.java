package tests.junit.extendeddb.jdbc;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import persistence.extendeddb.ExtendedDatabaseAPI;
import persistence.extendeddb.MixedResult;
import persistence.extendeddb.MixedResults;
import persistence.extendeddb.SQLConfiguration;
import persistence.extendeddb.TextualConfiguration;
import persistence.extendeddb.jdbc.SQLResult;
import persistence.extendeddb.jdbc.SQLResults;
import persistence.extendeddb.jdbc.SQLSearcher;
import persistence.extendeddb.lucene.Indexer;


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
				assertNotNull(sqlResult.getAttributes());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
