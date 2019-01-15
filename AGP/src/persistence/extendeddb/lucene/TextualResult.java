/**
 * 
 */
package persistence.extendeddb.lucene;

/**
 *
 */
public class TextualResult {
	private int id;
	private int score;
	private String content;
	
	
	public TextualResult(int id, int score, String content) {
		this.id = id;
		this.score = score;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public int getScore() {
		return score;
	}

	public String getContent() {
		return content;
	}
}
