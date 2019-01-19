package com.sanjaygoyaljpr.fts.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.sanjaygoyaljpr.fts.service.IIndexService;
import com.sanjaygoyaljpr.fts.wrapper.Document;

/**
 * This class is used to cater Indexing and Search Functionality.
 * 
 * @author Sanjay Goyal
 *
 */
@Service
public class IndexService implements IIndexService {

	Map<String, Document> documentSource = null;
	Map<String, HashSet<String>> index;

	public IndexService() {
		documentSource = new ConcurrentHashMap<>();
		index = new ConcurrentHashMap<String, HashSet<String>>();
	}

	/**
	 * This method is used to add new document and create index.
	 * 
	 * @author Sanjay Goyal
	 */
	@Override
	public void addDocumentAndBuildIndex(Document document) {
		documentSource.put(document.getId(), document);

		for (String token : document.getText().split(" ")) {
			token = token.toLowerCase();
			if (!index.containsKey(token)) {
				index.put(token, new HashSet<String>());
			}
			index.get(token).add(document.getId());
		}
	}

	/**
	 * This method is used to search documents based on query.
	 * 
	 * @author Sanjay Goyal
	 */
	@Override
	public List<Document> searchDocuments(String query) {
		List<Document> documents = null;
		Map<String, Integer> docCountMap = new HashMap<>();

		// tokenise
		for (String token : query.split(" ")) {

			// normalise
			token = token.toLowerCase();

			Set<String> docIdsSet = index.get(token);

			if (docIdsSet != null) {
				for (String docId : docIdsSet) {
					if (docCountMap.containsKey(docId)) {
						docCountMap.put(docId, docCountMap.get(docId) + 1);
					} else {
						docCountMap.put(docId, 1);
					}
				}
			}
		}
		
		// Make Relevance Search
		if (!docCountMap.isEmpty()) {
			documents = new LinkedList<>();
			List<Entry<String, Integer>> docIdlist = new LinkedList<>(docCountMap.entrySet());

			// Sorting the list based on values
			Collections.sort(docIdlist, new Comparator<Entry<String, Integer>>() {
				public int compare(Entry<String, Integer> doc1, Entry<String, Integer> doc2) {
					return doc2.getValue().compareTo(doc1.getValue());
				}
			});

			for (Entry<String, Integer> entry : docIdlist) {
				documents.add(documentSource.get(entry.getKey()));
			}
		}

		return documents;
	}

	@Override
	public boolean validateDocument(String documentId) {
		return !(documentSource.get(documentId) != null);
	}

}
