package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Entity.Tweet;
import com.masai.Entity.User;
import com.masai.Service.TwitterService;

@RestController
public class TwitterController {

	@Autowired
	TwitterService twitterService;
	
	@PostMapping("/user")
	public ResponseEntity<String> addUser(@RequestBody User user){
		
		twitterService.addUser(user);
		ResponseEntity<String> response = new ResponseEntity<String>("User added successfully", HttpStatus.CREATED);
		return response;
	}
	
	@PostMapping("/tweet")
	public ResponseEntity<String> createTweet(@RequestBody Tweet tweet){
		
		twitterService.createTweet(tweet);
		ResponseEntity<String> response = new ResponseEntity<String>("Tweet added successfully", HttpStatus.CREATED);
		return response;
	}
	
	@PatchMapping("/like/{tweetId}/{userId}")
	public ResponseEntity<String> likeTweet(@PathVariable String tweetId, @PathVariable String userId){
		
		twitterService.likeTweet(tweetId, userId);
		ResponseEntity<String> response = new ResponseEntity<String>("Tweet liked successfully", HttpStatus.CREATED);
		return response;
	}
	
	@PatchMapping("/retweet/{tweetId}/{userId}")
	public ResponseEntity<String> reTweet(@PathVariable String tweetId, @PathVariable String userId){
		
		twitterService.reTweet(tweetId, userId);
		ResponseEntity<String> response = new ResponseEntity<String>("Tweet liked successfully", HttpStatus.CREATED);
		return response;
	}
	
	@GetMapping("/tweets/{userId}")
	public ResponseEntity<List<Tweet>> getAllTweets(@PathVariable String userId){
		
		List<Tweet> tweetList = twitterService.getAllTweets(userId);
		return new ResponseEntity<List<Tweet>>(tweetList, HttpStatus.OK);
	}
	
}
