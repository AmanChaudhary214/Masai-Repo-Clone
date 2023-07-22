package com.masai.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.masai.Entity.Tweet;
import com.masai.Entity.User;
import com.masai.Exception.InvalidInputException;
import com.masai.Exception.NotFoundException;

import jakarta.annotation.PostConstruct;

@Service
public class TwitterService {

	
	private final Map<String, Tweet> tweets = new HashMap<>();
	private final Map<String, User> users = new HashMap<>();
	
//	private final Map<String, Like> likes = new HashMap<>();
//	private final Map<String, Retweet> retweet = new HashMap<>();
	
	
	@PostConstruct
	public void init() {
		
		User u1 = new User("u1", "User1", "user1@gmail.com");
		User u2 = new User("u2", "User2", "user2@gmail.com");
		users.put(u1.getUserId(), u1);
		users.put(u2.getUserId(), u2);
		
		Tweet t1 = new Tweet("t1", "u1", "First tweet", Arrays.asList("u2", "u3"), Arrays.asList("u2", "u3"));
		Tweet t2 = new Tweet("t2", "u2", "First tweet", Arrays.asList("u1", "u3"), Arrays.asList("u1", "u3"));
		tweets.put(t1.getTweetId(), t1);
		tweets.put(t2.getTweetId(), t2);
		
	}
	

	public void addUser(User user) {
		users.put(user.getUserId(), user);
	}


	public void createTweet(Tweet tweet) {
		if (tweet.getTweetId()==null || tweet.getContent()==null) {
			throw new NotFoundException("Enter valid details");
		}
		if (tweet.getUserId()==null || users.get(tweet.getUserId())==null) {
			throw new NotFoundException("User not found");
		}
		
		tweets.put(tweet.getTweetId(), tweet);
	}


	public void likeTweet(String tweetId, String userId) {
		Tweet tweet = tweets.get(tweetId);
		
		if (tweet.getTweetId()==null || tweet.getUserId()==null) {
			throw new InvalidInputException("Enter valid details");
		}
		tweet.getLikes().add(userId);
		tweets.put(tweet.getTweetId(), tweet);
	}


	public void reTweet(String tweetId, String userId) {
		Tweet tweet = tweets.get(tweetId);
		Tweet tweet1 = tweet;
		tweet1.setUserId(userId);
		
		if (tweet.getTweetId()==null || tweet.getUserId()==null) {
			throw new InvalidInputException("Enter valid details");
		}
		tweets.put(userId, tweet1);
	}


	public List<Tweet> getAllTweets(String userId) {
		User user1 = users.get(userId);
		
		if (user1 == null) {
			throw new NotFoundException("User not found");
		}
		
		List<Tweet> tweetList = new ArrayList<>();
		for (Tweet tweet : tweets.values()) {
			if (tweet.getUserId().equals(userId)) {
				tweetList.add(tweet);
			}
		}
		return tweetList;
	}
	
	
}
