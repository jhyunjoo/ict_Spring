package com.spring.ajax_ict05.dto;

public class SearchDTO {
	
	private String keyword;

	public SearchDTO() {
		super();
	}

	public SearchDTO(String keyword) {
		super();
		this.keyword = keyword;
	}

	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}
