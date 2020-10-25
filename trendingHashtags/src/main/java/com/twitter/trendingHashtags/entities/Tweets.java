package com.twitter.trendingHashtags.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="tweetid",initialValue=1,allocationSize=50)
public class Tweets {
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tweetid")
	@Id private long tweetId;
	private String tweet;
	public Tweets(long tweetId, String tweet) {
		super();
		this.tweetId = tweetId;
		this.tweet = tweet;
	}
	public Tweets() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getTweetId() {
		return tweetId;
	}
	public void setTweetId(long tweetId) {
		this.tweetId = tweetId;
	}
	public String getTweet() {
		return tweet;
	}
	public void setTweet(String tweet) {
		this.tweet = tweet;
	}
	@Override
	public String toString() {
		return "Tweets [tweetId=" + tweetId + ", tweet=" + tweet + "]";
	}
	

}
