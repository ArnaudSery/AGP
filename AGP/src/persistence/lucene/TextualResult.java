/**
 * 
 */
package persistence.lucene;

/**
 *
 */
public class TextualResult {
	private int id;
	private int score;
	private String description;
	
	
	public TextualResult(int id, int score, String description) {
		this.id = id;
		this.score = score;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public int getScore() {
		return score;
	}

	public String getDescription() {
		return description;
	}
}
