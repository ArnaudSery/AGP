/**
 * 
 */
package persistence.extendeddb;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class MixedResults implements Iterable<MixedResult> {
	private List<MixedResult> tuples;
	private int currentIndex;
	
	
	public MixedResults() {
		this.tuples = new LinkedList<MixedResult>();
		this.currentIndex = 0;
	}
	
	public void addTuple(MixedResult tuple) {
		tuples.add(tuple);
	}
	
	public MixedResult get(int index) {
		return tuples.get(index);
	}
	
	public void init() {
		this.currentIndex = 0;
	}
	
	public int size() {
		return tuples.size();
	}
	
	public boolean hasNext() {
		return currentIndex < size();
	}
	
	public MixedResult next() {
		if (hasNext()) {
			return get(currentIndex++);
		} else {
			return null;
		}
	}

	@Override
	public Iterator<MixedResult> iterator() {
		return tuples.iterator();
	}
}
