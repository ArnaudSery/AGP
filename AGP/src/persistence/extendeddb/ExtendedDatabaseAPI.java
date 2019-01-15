/**
 * 
 */
package persistence.extendeddb;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import org.apache.lucene.queryparser.classic.ParseException;

import persistence.ExtendedDatabaseAPI;
import persistence.extendeddb.jdbc.SQLResult;
import persistence.extendeddb.jdbc.SQLResults;
import persistence.extendeddb.jdbc.SQLSearcher;
import persistence.extendeddb.lucene.Searcher;
import persistence.extendeddb.lucene.TextualResult;
import persistence.extendeddb.lucene.TextualResults;

/**
 *
 */
public class ExtendedDatabaseAPI {
	private SQLConfiguration sqlConfiguration;
	private TextualConfiguration textualConfiguration;
	private SQLSearcher databaseConnection;
	
	
	public ExtendedDatabaseAPI(SQLConfiguration sqlConfiguration, TextualConfiguration textualConfiguration) {
		this.sqlConfiguration = sqlConfiguration;
		this.textualConfiguration = textualConfiguration;
	}
	
	private SQLSearcher getDatabaseConnection() {
		if (databaseConnection == null) {
			databaseConnection = new SQLSearcher(
					sqlConfiguration.getUrl(),
					sqlConfiguration.getUser(),
					sqlConfiguration.getPassword()
			);
		}
		
		return databaseConnection;
	}
	
	public SQLResults simpleQuery(String query) throws SQLException {
		return getDatabaseConnection().search(query);
	}
	
	public TextualResults textualQuery(String query) throws IOException, ParseException {
		Searcher searcher = new Searcher(textualConfiguration.getIndexPath());
		return searcher.search(query);
	}

	public MixedResults query(String mixedQuery) throws SQLException, IOException, ParseException {
		String sqlQuery;
		String[] partsQuery;
		boolean hasTextualQuery;
		boolean hasTableForJoin;
		SQLResults sqlResults;
		TextualResults textualResults;
		MixedResults mixedResults;
		int documentId;
		int tupleId;
		Map<String, String> attributes;
		
		partsQuery = mixedQuery.split("(?i: WITH )");
		sqlQuery = partsQuery[0];
		
		hasTextualQuery = partsQuery.length == 2;
		hasTableForJoin = sqlQuery.matches("(?i:.*FROM.* " + textualConfiguration.getTable() + ".*)");
		
		if (hasTextualQuery && hasTableForJoin) {
			textualResults = textualQuery(partsQuery[1]);
			
			sqlQuery = sqlQuery.substring(0, 7)
					   + textualConfiguration.getTable() + "."
					   + textualConfiguration.getJoinKey() + ", "
					   + sqlQuery.substring(7);
			
			sqlResults = simpleQuery(sqlQuery);
			
			mixedResults = new MixedResults();
			
			for (TextualResult textualResult : textualResults) {
				documentId = textualResult.getId();
				
				for (SQLResult tuple : sqlResults) {
					attributes = tuple.getAttributes();
					tupleId = Integer.parseInt(attributes.get(textualConfiguration.getJoinKey()));
					
					if (documentId == tupleId) {
						mixedResults.addTuple(new MixedResult(tuple, textualResult));
						break;
					}
				}
			}
			
			return mixedResults;
			
		} else {
			// Returns 0 results (no textual result)
			return new MixedResults();
		}
	}
}
