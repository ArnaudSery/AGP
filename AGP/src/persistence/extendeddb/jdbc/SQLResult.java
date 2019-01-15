/**
 * 
 */
package persistence.extendeddb.jdbc;

import java.util.HashMap;
import java.util.Map;

/**
 * SQLResult class
 * 
 * Used to store a tuple of an SQL result.
 */
public class SQLResult {
	Map<String, String> attributes;
	
	/**
	 * SQLResult constructor
	 */
	public SQLResult() {
		this.attributes = new HashMap<String, String>();
	}
	
	/**
	 * addAttribute
	 * 
	 * Store the content of an attribute into this structure.
	 * 
	 * @param attribute The name of the attribute.
	 * @param value     The value of this attribute.
	 */
	public void addAttribute(String attribute, String value) {
		attributes.put(attribute, value);
	}
	
	/**
	 * getNumberAttributes
	 * 
	 * Returns the number of pairs attributes / values stored.
	 * 
	 * @return Integer
	 */
	public int getNumberAttributes() {
		return attributes.size();
	}
	
	/**
	 * getAttributes
	 * 
	 * Returns all attributes stored in this structure in a Map.
	 * 
	 * @return Map<String, String>
	 */
	public Map<String, String> getAttributes() {
		return attributes;
	}
}
