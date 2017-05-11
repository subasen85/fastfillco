package com.nurds.fastfillco;

public class Response {

	private String responseCode;
	
	private String error;
	
	private ResponseObject resObject;
	
	private long str;
	
	

	public long getStr() {
		return str;
	}

	public void setStr(long str) {
		this.str = str;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public ResponseObject getObject() {
		return resObject;
	}

	public void setObject(ResponseObject object) {
		this.resObject = object;
	}
	
	
}
