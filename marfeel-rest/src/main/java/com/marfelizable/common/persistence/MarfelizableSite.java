package com.marfelizable.common.persistence;

import org.springframework.data.annotation.Id;

public class MarfelizableSite {
	
	@Id
	private String id;
	
	private String url;
	private Integer rank;
	
	public MarfelizableSite() {
		
	}
	
	public MarfelizableSite(String url, Integer rank) {
		this.url = url;
		this.rank = rank;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

}
