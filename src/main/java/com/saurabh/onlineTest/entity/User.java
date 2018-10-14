package com.saurabh.onlineTest.entity;


public class User {
	
	private String userId;
	private String userName;
	private String testId;
	private int score;
	
	public User(){
		
	}
	
	public User(String userId, String userName, String testId, int score) {
		this.userId = userId;
		this.userName = userName;
		this.testId = testId;
		this.score = score;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
	
}
