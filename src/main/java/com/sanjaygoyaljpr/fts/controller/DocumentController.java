package com.sanjaygoyaljpr.fts.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanjaygoyaljpr.fts.constants.ApplicationConstants;
import com.sanjaygoyaljpr.fts.service.IDocumentService;
import com.sanjaygoyaljpr.fts.wrapper.Document;
import com.sanjaygoyaljpr.fts.wrapper.Response;

/**
 * This class is used to cater document services.
 * 
 * @author Sanjay Goyal
 *
 */
@RestController
@RequestMapping("/document")
public class DocumentController {

	Logger LOG = LoggerFactory.getLogger(DocumentController.class);

	@Autowired
	private IDocumentService documentService;

	/**
	 * This method is used to add new document.
	 */
	@PostMapping(value = { "/" })
	public Response addDocument(@RequestBody Document document) {
		Response response = null;
		try {
			response = documentService.addDocument(document);
		} catch (Exception e) {
			LOG.error(e.getStackTrace().toString());
			response = new Response(ApplicationConstants.ERROR_CODE, ApplicationConstants.FAILURE_MSG);
		}
		return response;
	}

}
