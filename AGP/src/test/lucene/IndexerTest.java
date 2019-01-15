package test.lucene;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

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
import persistence.extendeddb.lucene.Searcher;
import persistence.extendeddb.lucene.TextualResult;
import persistence.extendeddb.lucene.TextualResults;

class IndexerTest {

	/*@Test
	void testLucene() {
		Path sourcePath = Paths.get("C:\\DATA");
		Path indexPath = Paths.get("C:\\INDEX");
		
		try {
			Indexer index = new Indexer(sourcePath, indexPath);
			
			index.createIndex(true);
			index.addDocuments(sourcePath);
			index.close();
			
			/*Searcher searcher = new Searcher(indexPath);
			TextualResults textualResults = searcher.search("motcle");
			
			TextualResult textualResult;
			
			while (textualResults.hasNext()) {
				textualResult = textualResults.next();
				System.out.println("id:" + textualResult.getId()
								   + " score:" + textualResult.getScore()
								   + " content:" + textualResult.getDescription());
			}
			
			for (TextualResult textualResult : textualResults) {
				System.out.println("id:" + textualResult.getId()
								   + " score:" + textualResult.getScore()
								   + " content:" + textualResult.getDescription());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
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
				System.out.println(sqlResult.getAttributes());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	@Test
	void testAPI() {
		Path sourcePath = Paths.get("C:\\DATA");
		Path indexPath = Paths.get("C:\\INDEX");
		
		SQLConfiguration sqlConfiguration = new SQLConfiguration(
				"mysql",
				"localhost",
				"travelDB",
				"root",
				"password"
		);
		
		TextualConfiguration textualConfiguration = new TextualConfiguration(
				sourcePath,
				indexPath,
				"Place",
				"id"
		);
		
		try {
			ExtendedDatabaseAPI database = new ExtendedDatabaseAPI(sqlConfiguration, textualConfiguration);
			/*SQLResults sqlResults = database.simpleQuery("SELECT name, type FROM Place WHERE type = 'historic'");
			
			for (SQLResult sqlResult : sqlResults) {
				System.out.println(sqlResult.getAttributes());
			}
			
			TextualResults textualResults = database.textualQuery("cergy");
			
			for (TextualResult textualResult : textualResults) {
				System.out.println("id:" + textualResult.getId()
								   + " score:" + textualResult.getScore()
								   + " content:" + textualResult.getContent());
			}
			System.out.println("=======================================");*/
			MixedResults mixedResults = database.MixedQuery("SELECT name, type FROM Place WITH musée");
			
			for (MixedResult mixedResult : mixedResults) {
				System.out.println("=========" + mixedResult.getAttribute("name") + "=========");
				System.out.println(" type:" + mixedResult.getAttribute("type") + " score:" + mixedResult.getScore());
				System.out.println("DESCRIPTION:" + mixedResult.getContent());
			}
			
			System.out.println("=======================================");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
