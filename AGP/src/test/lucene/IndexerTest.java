package test.lucene;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

import org.apache.lucene.queryparser.classic.ParseException;
import org.junit.jupiter.api.Test;

import persistence.lucene.Indexer;
import persistence.lucene.SearchResult;
import persistence.lucene.Searcher;

class IndexerTest {

	@Test
	void test() {
		Indexer index = new Indexer("C:\\DATA", "C:\\INDEX");
		index.createIndex(true);
		index.addDocuments("C:\\DATA");
		index.closeConnection();
		
		Searcher searcher = new Searcher("C:\\DATA", "C:\\INDEX");
		try {
			List<SearchResult> searchResult = searcher.search("poney");
			
			for (SearchResult result : searchResult) {
				System.out.println("RESULT : id:" + result.getId() + " score:" + result.getScore() + " descr:" + result.getDescription());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
