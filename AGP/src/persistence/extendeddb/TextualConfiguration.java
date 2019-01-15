/**
 * 
 */
package persistence.extendeddb;

import java.nio.file.Path;

/**
 *
 */
public class TextualConfiguration {
	private Path sourcePath;
	private Path indexPath;
	private String table;
	private String joinKey;
	
	
	public TextualConfiguration() {

	}
	
	public TextualConfiguration(Path sourcePath, Path indexPath, String table, String joinKey) {
		this.sourcePath = sourcePath;
		this.indexPath = indexPath;
		this.table = table;
		this.joinKey = joinKey;
	}

	public Path getSourcePath() {
		return sourcePath;
	}

	public void setSourcePath(Path sourcePath) {
		this.sourcePath = sourcePath;
	}

	public Path getIndexPath() {
		return indexPath;
	}

	public void setIndexPath(Path indexPath) {
		this.indexPath = indexPath;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getJoinKey() {
		return joinKey;
	}

	public void setJoinKey(String joinKey) {
		this.joinKey = joinKey;
	}
}
