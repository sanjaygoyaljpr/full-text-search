package com.sanjaygoyaljpr.fts.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanjaygoyaljpr.fts.constants.ApplicationConstants;
import com.sanjaygoyaljpr.fts.service.IDocumentService;
import com.sanjaygoyaljpr.fts.service.IIndexService;
import com.sanjaygoyaljpr.fts.wrapper.Document;
import com.sanjaygoyaljpr.fts.wrapper.Response;

/**
 * This class is used to cater document services.
 * 
 * @author Sanjay Goyal
 *
 */
@Service
public class DocumentService implements IDocumentService {

	@Autowired
	private IIndexService indexService;

	/**
	 * This method is used to add new document and create index.
	 * 
	 * @author Sanjay Goyal
	 */
	@Override
	public Response addDocument(Document document) throws Exception {
		Response response = null;

		// Validate Document for unique id
		if (indexService.validateDocument(document.getId())) {
			indexService.addDocumentAndBuildIndex(document);
			response = new Response(ApplicationConstants.SUCCESS_CODE, ApplicationConstants.DOCUMENT_SUCCESS_MSG);
		} else {
			response = new Response(ApplicationConstants.VALIDATION_DUPLICATE_DOC_ID_CODE,
					ApplicationConstants.DOCUMENT_DUPLICATE_MSG);
		}

		return response;
	}

}
