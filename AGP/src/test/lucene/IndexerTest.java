package test.lucene;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import persistence.lucene.Indexer;

class IndexerTest {

	@Test
	void test() {
		Indexer index = new Indexer("C:\\DATA", "C:\\INDEX");
		index.createIndex(true);
		index.addDocuments("C:\\DATA");
		index.closeConnection();
	}

}
