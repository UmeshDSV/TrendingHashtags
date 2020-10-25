package com.twitter.trendingHashtags.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twitter.trendingHashtags.dao.TweetsDAO;
import com.twitter.trendingHashtags.entities.Tweets;

@Service
public class TweetServiceImpl implements TweetService {
	
	@Autowired
	private TweetsDAO tweetsDao;
	
	@Override
	public String userTweet(Tweets tweet) {
		this.tweetsDao.save(tweet);
		return "Successfully Tweeted";
	}

	@Override
	public List<String> trendingTweets() {
		List<Tweets> tweets;
		tweets = new ArrayList<Tweets>();
		tweets = this.tweetsDao.findAll();
		Map<String, Integer> trending = new HashMap<String, Integer>();
		for(Tweets t : tweets) {
			String s = t.getTweet();
			Pattern hashtagPattern = Pattern.compile("#(\\w+)");
			Matcher m = hashtagPattern.matcher(s);
			while(m.find()) {
				trending.put(m.group(1), trending.getOrDefault(m.group(1), 0) + 1);
			}
		}
		PriorityQueue<String> hashtags = new PriorityQueue<String>(
				(c1,c2) -> trending.get(c1).equals(trending.get(c2)) ?
						c2.compareTo(c1) : trending.get(c1)-trending.get(c2));
		for(String tag:trending.keySet()) {
			hashtags.offer(tag);
			if(hashtags.size() > 10) hashtags.poll();
		}
		List<String> trendingHashtags = new ArrayList<String>();
		while(!hashtags.isEmpty()) trendingHashtags.add(hashtags.poll());
		Collections.reverse(trendingHashtags);
 		return trendingHashtags;
	}

}
