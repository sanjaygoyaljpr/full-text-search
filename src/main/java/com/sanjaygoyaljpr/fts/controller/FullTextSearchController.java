package com.sanjaygoyaljpr.fts.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sanjaygoyaljpr.fts.constants.ApplicationConstants;
import com.sanjaygoyaljpr.fts.service.IFullTextSearchService;
import com.sanjaygoyaljpr.fts.wrapper.Response;

@RestController
@RequestMapping("/fts")
public class FullTextSearchController {

	Logger LOG = LoggerFactory.getLogger(FullTextSearchController.class);

	@Autowired
	private IFullTextSearchService fts;

	/**
	 * This method is used to search documents based on query.
	 * 
	 * @author Sanjay Goyal
	 */
	@GetMapping(value = { "/search" })
	public Response searchDocuments(@RequestParam(required = true) String query) {
		Response response = null;
		try {
			response = fts.searchDocuments(query);
		} catch (Exception e) {
			LOG.error(e.getStackTrace().toString());
			response = new Response(ApplicationConstants.ERROR_CODE, ApplicationConstants.FAILURE_MSG);
		}
		return response;
	}

}
