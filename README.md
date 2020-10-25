# TrendingHashtags
API to fetch top 10 trending hashtags

To Post the tweet 
Http post request - localhost:8080/tweet
with input (JSON Format) e.g - { "tweet":" Worlds best cricketer is #sachin"}

To get Top 10 trending Hashtags
Http get request - localhost:8080/trendingHashtags


Database name - twitter
Table Name - tweets
Table Schema - 
tweet_id BigInt PRIMARY KEY,
tweet varchar
