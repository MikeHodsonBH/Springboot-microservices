package com.june.apps.models;

import java.util.List;

public class Request {
	
	private String ci;
	private String profileChange;
	private List<String> contentToFilter;
	
	public Request() {}

	public Request(String ci, String profileChange, List<String> contentToFilter) {
		super();
		this.ci = ci;
		this.profileChange = profileChange;
		this.contentToFilter = contentToFilter;
	}

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public String getProfileChange() {
		return profileChange;
	}

	public void setProfileChange(String profileChange) {
		this.profileChange = profileChange;
	}

	public List<String> getContentToFilter() {
		return contentToFilter;
	}

	public void setContentToFilter(List<String> contentToFilter) {
		this.contentToFilter = contentToFilter;
	}
	
}
