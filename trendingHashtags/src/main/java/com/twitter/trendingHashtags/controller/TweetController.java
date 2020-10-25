package com.twitter.trendingHashtags.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.trendingHashtags.entities.Tweets;
import com.twitter.trendingHashtags.services.TweetService;

@RestController
public class TweetController {

	@Autowired
	private TweetService tweetService;
	
	@PostMapping("/tweet")
	public String userTweet(@RequestBody Tweets tweet) {
		
		return this.tweetService.userTweet(tweet);
	}
}
