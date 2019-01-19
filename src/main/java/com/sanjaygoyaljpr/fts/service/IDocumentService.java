package com.sanjaygoyaljpr.fts.service;

import com.sanjaygoyaljpr.fts.wrapper.Document;
import com.sanjaygoyaljpr.fts.wrapper.Response;

public interface IDocumentService {

	Response addDocument(Document document) throws Exception;

}
