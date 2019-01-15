package test.lucene;

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
import persistence.extendeddb.lucene.TextualResult;
import persistence.extendeddb.lucene.TextualResults;

class TestQuery {

	
	
	@Test
	void testJDBC() {
		String host = "localhost";
		String base = "travelDB";
		String user = "root";
		String password = "password";
		String url = "jdbc:mysql://" + host + "/" + base;
		
		try {
			SQLSearcher searcher = new SQLSearcher(url, user, password);
			SQLResults sqlResults = searcher.search("SELECT id, name, type FROM Place");
			
			for (SQLResult sqlResult : sqlResults) {
				System.out.println(sqlResult.getAttributes());
			}
			
			System.out.println("---");
			SQLResult sqlResult;
			
			while (sqlResults.hasNext()) {
				sqlResult = sqlResults.next();
				assertNotNull(sqlResult.getAttributes());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testMixedQuery() {
		Path sourcePath = Paths.get("C:\\DATA");
		Path indexPath = Paths.get("C:\\INDEX");
		
		SQLConfiguration sqlConfiguration = new SQLConfiguration(
				"mysql",
				"localhost",
				"travelDB",
				"root",
				""
		);
		
		TextualConfiguration textualConfiguration = new TextualConfiguration(
				sourcePath,
				indexPath,
				"Place",
				"id"
		);
		
		try {
			Indexer index = new Indexer(sourcePath, indexPath);
			
			index.createIndex(true);
			index.addDocuments(sourcePath);
			index.close();
			
			ExtendedDatabaseAPI database = new ExtendedDatabaseAPI(sqlConfiguration, textualConfiguration);
			MixedResults sqlResults = database.MixedQuery("SELECT name, type FROM Place with musée");
			for(MixedResult result : sqlResults) {
				assertNotNull(result.getContent());
				assertTrue(result.getScore() >= 0 );
				assertNotNull(result.getAttribute("name"));
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testTextualQuery() {
		Path sourcePath = Paths.get("C:\\DATA");
		Path indexPath = Paths.get("C:\\INDEX");
		
		SQLConfiguration sqlConfiguration = new SQLConfiguration(
				"mysql",
				"localhost",
				"travelDB",
				"root",
				""
		);
		
		TextualConfiguration textualConfiguration = new TextualConfiguration(
				sourcePath,
				indexPath,
				"Place",
				"id"
		);
		
		try {
			Indexer index = new Indexer(sourcePath, indexPath);
			
			index.createIndex(true);
			index.addDocuments(sourcePath);
			index.close();
			
			ExtendedDatabaseAPI database = new ExtendedDatabaseAPI(sqlConfiguration, textualConfiguration);
		
			TextualResults textualResults = database.textualQuery("musée");
			
			for (TextualResult textualResult : textualResults) {
				assertNotNull(textualResult.getId() >= 0);
				assertTrue(textualResult.getScore() > 0);
				assertNotNull(textualResult.getContent());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
