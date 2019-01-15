/**
 * 
 */
package persistence.extendeddb;

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
		if (textualResult != null) {
			return textualResult.getContent();
		} else {
			return null;
		}
	}
	
	public int getScore() {
		if (textualResult != null) {
			return textualResult.getScore();
		} else {
			return 0;
		}
	}
}
