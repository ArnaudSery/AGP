/**
 * 
 */
package persistence.lucene;

/**
 *
 */
public class SearchResult {
	private int id;
	private float score;
	private String description;
	
	
	public SearchResult(int id, float score, String description) {
		this.id = id;
		this.score = score;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public float getScore() {
		return score;
	}

	public String getDescription() {
		return description;
	}
}
