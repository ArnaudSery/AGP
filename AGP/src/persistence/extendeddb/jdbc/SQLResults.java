/**
 * 
 */
package persistence.extendeddb.jdbc;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class SQLResults implements Iterable<SQLResult> {
	private List<SQLResult> tuples;
	private int currentIndex;
	
	
	public SQLResults() {
		this.tuples = new LinkedList<SQLResult>();
		this.currentIndex = 0;
	}
	
	public void addTuple(SQLResult tuple) {
		tuples.add(tuple);
	}
	
	public SQLResult get(int index) {
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
	
	public SQLResult next() {
		if (hasNext()) {
			return get(currentIndex++);
		} else {
			return null;
		}
	}

	@Override
	public Iterator<SQLResult> iterator() {
		return tuples.iterator();
	}
}
