/**
 * 
 */
package persistence.extendeddb.lucene;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

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
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

/**
 *
 */
public class Searcher {
	private final int MAX_RESULTS = 100;
	private Path indexPath;
	
	
	public Searcher(Path indexPath) {
		this.indexPath = indexPath;
	}
	
	public TextualResults search(String query) throws IOException, ParseException {
		Directory directory;
		Analyzer analyzer;
		IndexReader reader;
		IndexSearcher searcher;
		QueryParser parser;
		Query parsedQuery;
		ScoreDoc[] results;
		
		File documentFile;
		FileReader fileReader;
		BufferedReader bufferedReader;
		Document document;
		
		int id;
		int score;
		String filename;
		String filenameWExt;
		String description;
		String line;
		TextualResults textualResults;
		
		
		if (query.isEmpty()) {
			System.err.println("Error : a query is required.");
		}
		
		
		analyzer = new StandardAnalyzer();
		parser = new QueryParser("content", analyzer);
		
		directory = FSDirectory.open(indexPath);
		reader = DirectoryReader.open(directory);
		searcher = new IndexSearcher(reader);
		
		parsedQuery = parser.parse(query);
		results = searcher
					.search(parsedQuery, MAX_RESULTS)
					.scoreDocs;
		
		textualResults = new TextualResults();
		
		
		for (ScoreDoc result : results) {
			document = searcher.doc(result.doc);
			score = (int) (result.score * 1000);
			description = "";
			
			documentFile = new File(document.get("path"));
			fileReader = new FileReader(documentFile);
			bufferedReader = new BufferedReader(fileReader);
			
			while ((line = bufferedReader.readLine()) != null) {
				description += line + "\n";
			}
			
			filename = documentFile.getName();
			filenameWExt = filename.substring(0, filename.lastIndexOf("."));
			id = Integer.parseInt(filenameWExt);
			
			textualResults.add(new TextualResult(id, score, description));
			
			bufferedReader.close();
			fileReader.close();
		}
		
		reader.close();
		
		return textualResults;
	}
}
