/**
 * 
 */
package persistence.lucene;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class TextualResults implements Iterable<TextualResult> {
	private List<TextualResult> textualResults;
	private int currentIndex;
	
	
	public TextualResults() {
		this.textualResults = new LinkedList<TextualResult>();
		this.currentIndex = 0;
	}
	
	public void add(TextualResult result) {
		textualResults.add(result);
	}
	
	public TextualResult get(int index) {
		return textualResults.get(index);
	}
	
	public void init() {
		this.currentIndex = 0;
	}
	
	public int size() {
		return textualResults.size();
	}
	
	public boolean hasNext() {
		return currentIndex < size();
	}
	
	public TextualResult next() {
		if (hasNext()) {
			return get(currentIndex++);
		} else {
			return null;
		}
	}

	@Override
	public Iterator<TextualResult> iterator() {
		return textualResults.iterator();
	}
}
