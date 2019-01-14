/**
 * 
 */
package persistence.lucene;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.SimplePayloadFilter;
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
	private String sourceDirectory;
	private String indexDirectory;
	private IndexWriter writer;
	
	public Indexer(String sourceDirectory, String indexDirectory) {
		this.sourceDirectory = sourceDirectory;
		this.indexDirectory = indexDirectory;
	}
	
	public void createIndex(boolean recreateIndex) {
		Path sourcePath = Paths.get(sourceDirectory);
		Path indexPath = Paths.get(indexDirectory);
		
		if (!Files.isReadable(sourcePath)) {
			System.err.println("Error : sourcePath " + sourceDirectory + " does not exist or is not readable.");
		}
		
		if (!Files.isReadable(indexPath)) {
			System.err.println("Error : indexPath " + indexDirectory + " does not exist or is not readable.");
		}
		
		try {
			Directory dir = FSDirectory.open(indexPath);
			Analyzer analyzer = new StandardAnalyzer();
			IndexWriterConfig config = new IndexWriterConfig(analyzer);
			
			if (recreateIndex) {
				config.setOpenMode(OpenMode.CREATE);
			} else {
				config.setOpenMode(OpenMode.CREATE_OR_APPEND);
			}
			
			writer = new IndexWriter(dir, config);
			
		} catch (IOException e) {
			System.err.println("Error : " + e.getMessage());
		}
	}
	
	public void addDocument(String documentDirectory) {
		Path documentPath = Paths.get(documentDirectory);
		
		if (!Files.isReadable(documentPath)) {
			System.err.println("Error : documentPath " + documentDirectory + " does not exist or is not readable.");
		}
		
		try (InputStream stream = Files.newInputStream(documentPath)) {
			Document document = new Document();
			
			InputStreamReader inputStreamReader = new InputStreamReader(stream, StandardCharsets.UTF_8);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			TextField descriptionField = new TextField("description", bufferedReader);
			
			document.add(descriptionField);
			
			writer.addDocument(document);
			
		} catch (IOException e) {
			System.err.println("Error : " + e.getMessage());
		}
	}
	
	public void addDocuments(String documentsDirectory) {
		Path documentsPath = Paths.get(documentsDirectory);
		
		if (Files.isDirectory(documentsPath)) {
			try {
				Files.walkFileTree(documentsPath, new SimpleFileVisitor<Path>() {
					@Override
					public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
						addDocument(file.toString());
						return FileVisitResult.CONTINUE;
					}
				});
				
			} catch (IOException e) {
				System.err.println("Error : " + e.getMessage());
			}
		}
	}
	
	public void closeConnection() {
		try {
			writer.close();
		} catch (IOException e) {
			System.err.println("Error : " + e.getMessage());
		}
	}
	
	public String getSourceDirectory() {
		return sourceDirectory;
	}

	public void setSourceDirectory(String sourceDirectory) {
		this.sourceDirectory = sourceDirectory;
	}

	public String getIndexDirectory() {
		return indexDirectory;
	}

	public void setIndexDirectory(String indexDirectory) {
		this.indexDirectory = indexDirectory;
	}
}
