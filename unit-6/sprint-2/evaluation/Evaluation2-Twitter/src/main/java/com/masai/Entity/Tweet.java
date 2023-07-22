package com.masai.Entity;

import java.util.ArrayList;
import java.util.List;

public class Tweet {

	private String tweetId;
	private String userId;
	private String content;
	private List<String> likes = new ArrayList<>();
	private List<String> retweets = new ArrayList<>();

	public Tweet(String tweetId, String userId, String content, List<String> likes, List<String> retweets) {
		super();
		this.tweetId = tweetId;
		this.userId = userId;
		this.content = content;
		this.likes = likes;
		this.retweets = retweets;
	}

	public String getTweetId() {
		return tweetId;
	}

	public void setTweetId(String tweetId) {
		this.tweetId = tweetId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<String> getLikes() {
		return likes;
	}

	public void setLikes(List<String> likes) {
		this.likes = likes;
	}

	public List<String> getRetweets() {
		return retweets;
	}

	public void setRetweets(List<String> retweets) {
		this.retweets = retweets;
	}
	
}
