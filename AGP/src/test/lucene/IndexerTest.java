package test.lucene;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import persistence.lucene.Indexer;
import persistence.lucene.TextualResult;
import persistence.lucene.TextualResults;
import persistence.lucene.Searcher;

class IndexerTest {

	@Test
	void test() {
		Path sourcePath = Paths.get("C:\\DATA");
		Path indexPath = Paths.get("C:\\INDEX");
		
		try {
			Indexer index = new Indexer(sourcePath, indexPath);
			
			index.createIndex(true);
			index.addDocuments(sourcePath);
			index.close();
			
			Searcher searcher = new Searcher(indexPath);
			TextualResults textualResults = searcher.search("motcle");
			
			/*TextualResult textualResult;
			
			while (textualResults.hasNext()) {
				textualResult = textualResults.next();
				System.out.println("id:" + textualResult.getId()
								   + " score:" + textualResult.getScore()
								   + " content:" + textualResult.getDescription());
			}*/
			
			for (TextualResult textualResult : textualResults) {
				System.out.println("id:" + textualResult.getId()
								   + " score:" + textualResult.getScore()
								   + " content:" + textualResult.getDescription());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
