package com.masai.Entity;

public class Retweet {

	private String retweetId; 
	private String userId;
	private String tweetId;
	
	public Retweet(String retweetId, String userId, String tweetId) {
		super();
		this.retweetId = retweetId;
		this.userId = userId;
		this.tweetId = tweetId;
	}

	public String getRetweetId() {
		return retweetId;
	}

	public void setRetweetId(String retweetId) {
		this.retweetId = retweetId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTweetId() {
		return tweetId;
	}

	public void setTweetId(String tweetId) {
		this.tweetId = tweetId;
	}
	
}
