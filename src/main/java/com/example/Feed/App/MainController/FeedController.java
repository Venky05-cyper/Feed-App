package com.example.Feed.App.MainController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Feed.App.Bean.FeedApprovalRequest;
import com.example.Feed.App.Entity.FeedEntity;
import com.example.Feed.App.service.FeedService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/feed")
public class FeedController {

	@Autowired
	private FeedService feedService;

	@PostMapping("/submit")
	public String submitFeed(@RequestBody FeedEntity feedEntity) {
		return feedService.submitFeed(feedEntity);
	}

	@GetMapping("/pending")
	public List<FeedEntity> getPendingFeeds() {
		return feedService.getPendingFeeds();
	}

	@PutMapping("/approve/{feedId}")
	public String approveFeed(@PathVariable int feedId, @RequestBody FeedApprovalRequest request) {
		return feedService.approveFeed(feedId, request.isApproved());
	}

	@GetMapping("/approved")
	public List<FeedEntity> getApprovedFeeds() {
		return feedService.getApprovedFeeds();
	}

	@GetMapping("/getFeeds/{userId}")
	public List<FeedEntity> getFeedsByUserId(@PathVariable Integer userId) {
		// Fetch posts based on the userId
		return feedService.getFeedsByUserId(userId);
	}

	@DeleteMapping("/delete/{feedId}")
	public String deleteFeed(@PathVariable int feedId) {
		return feedService.deleteFeed(feedId);
	}

	@PutMapping("/update/{feedId}")
	public String updateFeed(@PathVariable int feedId, @RequestBody FeedEntity feedEntity) {
		return feedService.updateFeed(feedId, feedEntity);
	}

}
