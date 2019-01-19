package com.sanjaygoyaljpr.fts.service;

import java.util.List;

import com.sanjaygoyaljpr.fts.wrapper.Document;

public interface IIndexService {

	void addDocumentAndBuildIndex(Document document);

	List<Document> searchDocuments(String query);

	boolean validateDocument(String documentId);

}
