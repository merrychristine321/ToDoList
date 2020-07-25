package com.example.web;

public class UserForm {
	
	private String userId;
	private String userPw;
	private String userName;
	
	public UserForm() {
		this.userId = "";
		this.userPw = "";
		this.userName = "";
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String toString() {
		return "UserForm [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + "]";
	}
	
	

}
