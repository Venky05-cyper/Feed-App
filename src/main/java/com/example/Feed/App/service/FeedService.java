package com.example.Feed.App.service;

import java.util.List;

import com.example.Feed.App.Entity.FeedEntity;

public interface FeedService {

	String submitFeed(FeedEntity feedEntity);

	List<FeedEntity> getPendingFeeds();

	String approveFeed(int feedId, boolean approved);

	List<FeedEntity> getApprovedFeeds();

	List<FeedEntity> getFeedsByUserId(Integer userId);

	String deleteFeed(int feedId);

	String updateFeed(int feedId, FeedEntity feedEntity);

}
