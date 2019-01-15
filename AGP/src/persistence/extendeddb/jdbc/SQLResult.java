/**
 * 
 */
package persistence.extendeddb.jdbc;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class SQLResult {
	Map<String, String> attributes;
	
	
	public SQLResult() {
		this.attributes = new HashMap<String, String>();
	}
	
	public void addAttribute(String attribute, String value) {
		attributes.put(attribute, value);
	}
	
	public int getNumberAttributes() {
		return attributes.size();
	}

	public Map<String, String> getAttributes() {
		return attributes;
	}
}
