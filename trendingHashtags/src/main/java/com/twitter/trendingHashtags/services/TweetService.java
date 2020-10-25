package com.twitter.trendingHashtags.services;

import java.util.List;

import com.twitter.trendingHashtags.entities.Tweets;

public interface TweetService {
	public String userTweet(Tweets tweet);
	public List<String> trendingTweets();

}
