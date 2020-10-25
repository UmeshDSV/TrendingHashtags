package com.twitter.trendingHashtags.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.trendingHashtags.services.TweetService;

@RestController
public class HashtagController {

	@Autowired
	private TweetService tweetService;
	
	@GetMapping("/trendingHashtags")
	public List<String> trendingTweets() {
		return this.tweetService.trendingTweets();
	}

}
