/**
 * 
 */
package persistence.extendeddb;

import java.util.Map;

import persistence.extendeddb.jdbc.SQLResult;
import persistence.extendeddb.lucene.TextualResult;

/**
 *
 */
public class MixedResult {
	private SQLResult sqlResult;
	private TextualResult textualResult;
	
	
	public MixedResult(SQLResult sqlResult, TextualResult textualResult) {
		this.sqlResult = sqlResult;
		this.textualResult = textualResult;
	}
	
	public String getAttribute(String key) {
		return sqlResult.getAttributes().get(key);
	}
	
	public int getNumberAttributes() {
		return sqlResult.getNumberAttributes();
	}
	
	public String getContent() {
		return textualResult.getContent();
	}
	
	public int getScore() {
		return textualResult.getScore();
	}
}
