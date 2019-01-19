package com.sanjaygoyaljpr.fts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanjaygoyaljpr.fts.constants.ApplicationConstants;
import com.sanjaygoyaljpr.fts.service.IFullTextSearchService;
import com.sanjaygoyaljpr.fts.service.IIndexService;
import com.sanjaygoyaljpr.fts.wrapper.Document;
import com.sanjaygoyaljpr.fts.wrapper.Response;

/**
 * Full Text Search Web Service
 * 
 * @author Sanjay Goyal
 *
 */
@Service
public class FullTextSearchService implements IFullTextSearchService {

	@Autowired
	private IIndexService indexService;

	/**
	 * This method is used to search documents based on query.
	 * 
	 * @author Sanjay Goyal
	 */
	@Override
	public Response searchDocuments(String query) {
		Response response = null;

		List<Document> documents = indexService.searchDocuments(query);

		if (documents != null && !documents.isEmpty()) {
			response = new Response(ApplicationConstants.SUCCESS_CODE, ApplicationConstants.RECORDS_SUCCESS_MSG,
					documents.size(), documents);
		} else {
			response = new Response(ApplicationConstants.SUCCESS_CODE, ApplicationConstants.NO_RECORDS_FOUND);
		}

		return response;
	}

}
