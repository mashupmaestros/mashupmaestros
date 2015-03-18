package com.codesandgears.enterkonnect.beans;

import com.googlecode.objectify.annotation.Id;

import com.googlecode.objectify.annotation.Entity;

@Entity
public class Feed {
	
	@Id
    Long id;

    private String feedContent;
    private String feedOwner;
    private String feedDomain;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFeedContent() {
		return feedContent;
	}
	public void setFeedContent(String feedContent) {
		this.feedContent = feedContent;
	}
	public String getFeedOwner() {
		return feedOwner;
	}
	public void setFeedOwner(String feedOwner) {
		this.feedOwner = feedOwner;
	}
	public String getFeedDomain() {
		return feedDomain;
	}
	public void setFeedDomain(String feedDomain) {
		this.feedDomain = feedDomain;
	}
	@Override
	public String toString() {
		return "Feed [id=" + id + ", feedContent=" + feedContent
				+ ", feedOwner=" + feedOwner + ", feedDomain=" + feedDomain
				+ "]";
	}
	
    
}
