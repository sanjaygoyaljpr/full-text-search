package com.sanjaygoyaljpr.fts.wrapper;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

	private int responseCode;
	private String msg;

	private int count;
	private List<Document> documents;

	public Response() {
	}

	public Response(int responseCode, String msg) {
		this.responseCode = responseCode;
		this.msg = msg;
	}

	public Response(int responseCode, String msg, int count, List<Document> documents) {
		this.responseCode = responseCode;
		this.msg = msg;
		this.count = count;
		this.documents = documents;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

}
