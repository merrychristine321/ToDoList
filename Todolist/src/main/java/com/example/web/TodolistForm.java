package com.example.web;

public class TodolistForm {
	
	private String listId;
	private String content;
	private String uploadDate;
	
	public TodolistForm() {
		this.listId = "";
		this.content = "";
		this.uploadDate = "";
	}
	
	public String getListId() {
		return listId;
	}
	public void setListId(String listId) {
		this.listId = listId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
	
	@Override
	public String toString() {
		return "TodolistForm [listId=" + listId + ", content=" + content + ", uploadDate=" + uploadDate + "]";
	}
	
	

}
