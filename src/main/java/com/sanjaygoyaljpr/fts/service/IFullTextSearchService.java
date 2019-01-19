package com.sanjaygoyaljpr.fts.service;

import com.sanjaygoyaljpr.fts.wrapper.Response;

public interface IFullTextSearchService {

	Response searchDocuments(String query);

}
