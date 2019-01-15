/**
 * 
 */
package persistence.extendeddb.lucene;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

/**
 *
 */
public class Indexer {
	private Path sourcePath;
	private Path indexPath;
	private IndexWriter writer;
	
	
	public Indexer(Path sourcePath, Path indexPath) {
		this.sourcePath = sourcePath;
		this.indexPath = indexPath;
	}
	
	public void createIndex(boolean recreateIndex) throws IOException {
		Directory directory;
		Analyzer analyzer;
		IndexWriterConfig indexConfiguration;
		
		if (!Files.isReadable(sourcePath)) {
			System.err.println("Error : sourcePath "
							   + sourcePath.toString()
							   + " does not exist or is not readable.");
		}
		
		if (!Files.isReadable(indexPath)) {
			System.err.println("Error : indexPath "
							   + indexPath.toString()
							   + " does not exist or is not readable.");
		}
		
		directory = FSDirectory.open(indexPath);
		analyzer = new StandardAnalyzer();
		indexConfiguration = new IndexWriterConfig(analyzer);
		
		indexConfiguration.setOpenMode(
				(recreateIndex) ? OpenMode.CREATE : OpenMode.CREATE_OR_APPEND
		);
		
		writer = new IndexWriter(directory, indexConfiguration);
	}
	
	public void addDocument(Path documentPath) throws IOException {
		String absolutePathStr;
		File documentFile;
		FileReader fileReader;
		BufferedReader bufferedReader;
		Document document;
		
		
		if (writer == null) {
			System.err.println("Please initialize the writer before.");
		}
		
		if (!Files.isReadable(documentPath)) {
			System.err.println("Error : documentPath "
					   + documentPath.toString()
					   + " does not exist or is not readable.");
		}
		
		
		documentFile = documentPath.toFile();
		absolutePathStr = documentFile.getAbsolutePath();
		
		fileReader = new FileReader(documentFile);
		bufferedReader = new BufferedReader(fileReader);
		
		document = new Document();
		document.add(new StringField("path", absolutePathStr, Field.Store.YES));
		document.add(new TextField("content", bufferedReader));
		
		writer.addDocument(document);
		
		bufferedReader.close();
		fileReader.close();
	}
	
	public void addDocuments(Path documentsPath) throws IOException {
		if (Files.isDirectory(documentsPath)) {
			Files.walkFileTree(documentsPath, new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
						throws IOException {
					
					addDocument(file);
					return FileVisitResult.CONTINUE;
				}
			});
		} else {
			addDocument(documentsPath);
		}
	}
	
	public void close() throws IOException {
		writer.close();
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
}
