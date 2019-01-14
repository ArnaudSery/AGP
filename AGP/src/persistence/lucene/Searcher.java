/**
 * 
 */
package persistence.lucene;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;

/**
 *
 */
public class Searcher {
	private String indexDirectory;
	
	public Searcher(String indexDirectory) {
		this.indexDirectory = indexDirectory;
	}
	
	public List<SearchResult> search(String query) throws IOException, ParseException {
		
		if (query.isEmpty()) {
			System.err.println("Error : a query is required.");
		}
		
		Path indexPath = Paths.get(indexDirectory);
		
		Analyzer analyzer = new StandardAnalyzer();
		IndexReader reader = DirectoryReader.open(FSDirectory.open(indexPath));
		IndexSearcher searcher = new IndexSearcher(reader);
		
		QueryParser parser = new QueryParser("description", analyzer);
		Query parsedQuery = parser.parse(query);
		TopDocs results = searcher.search(parsedQuery, 100);
		ScoreDoc[] hits = results.scoreDocs;
		
		List<SearchResult> searchResult = new LinkedList<SearchResult>();
		
		Document document;
		int id;
		String description;
		
		for (ScoreDoc hit : hits) {
			document = searcher.doc(hit.doc);
			id = Integer.parseInt(document.get("id"));
			description = document.get("description");
			searchResult.add(new SearchResult(id, hit.score, description));
		}
		
		reader.close();
		
		return searchResult;
	}
}
