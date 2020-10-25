package com.twitter.trendingHashtags.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twitter.trendingHashtags.entities.Tweets;

public interface TweetsDAO extends JpaRepository<Tweets, Long> {

}
