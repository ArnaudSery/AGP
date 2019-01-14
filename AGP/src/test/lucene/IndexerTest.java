package test.lucene;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import persistence.lucene.Indexer;

class IndexerTest {

	@Test
	void test() {
		Indexer index = new Indexer(1, "C:\\Users\\Archambault Vincent\\Documents\\agp\\Data", "C:\\Users\\Archambault Vincent\\Documents\\agp\\Index");
		index.createIndex(true);
		index.addDocuments("C:\\Users\\Archambault Vincent\\Documents\\agp\\Data");
		index.closeConnection();
	}

}
