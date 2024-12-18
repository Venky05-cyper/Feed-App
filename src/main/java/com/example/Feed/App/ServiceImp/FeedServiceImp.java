package com.example.Feed.App.ServiceImp;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Feed.App.Entity.FeedEntity;
import com.example.Feed.App.Repository.FeedRepository;
import com.example.Feed.App.Repository.userRepository;
import com.example.Feed.App.service.FeedService;

@Service
public class FeedServiceImp implements FeedService {

	@Autowired
	FeedRepository feedRepo;

	@Autowired
	private userRepository userRepository;

	@Override
	public String submitFeed(FeedEntity feedEntity) {
		feedEntity.setStatus("pending");

		if (feedEntity.getCreatedDate() == null) {
			feedEntity.setCreatedDate(LocalDateTime.now());
		}
		feedRepo.save(feedEntity);
		return "Feed submitted successfully!";
	}

	@Override
	public List<FeedEntity> getPendingFeeds() {
		return feedRepo.findByStatus("pending");
	}

	@Override
	public String approveFeed(int feedId, boolean approved) {
		FeedEntity feedEntity = feedRepo.findById(feedId).orElse(null);
		if (feedEntity != null) {
			feedEntity.setStatus(approved ? "approved" : "rejected");
			feedRepo.save(feedEntity);
			return "Feed status updated!";
		}
		return "Feed not found!";
	}

	@Override
	public List<FeedEntity> getApprovedFeeds() {
		return feedRepo.findByStatus("approved");
	}

	@Override
	public List<FeedEntity> getFeedsByUserId(Integer userId) {
		return feedRepo.findByUserId(userId);
	}

	@Override
	public String deleteFeed(int feedId) {
		// Check if the feed exists
		if (feedRepo.existsById(feedId)) {
			feedRepo.deleteById(feedId); // Delete the feed from the database
			return "Feed deleted successfully";
		} else {
			return "Feed not found";
		}
	}

	@Override
	public String updateFeed(int feedId, FeedEntity feedEntity) {
		// Check if the feed exists
		if (feedRepo.existsById(feedId)) {
			FeedEntity existingFeed = feedRepo.findById(feedId).get(); // Retrieve the existing feed

			// Update the fields (you can customize this depending on the fields you want to
			// update)
			existingFeed.setTitle(feedEntity.getTitle()); // Update title
			existingFeed.setContent(feedEntity.getContent()); // Update content

			// Save the updated feed entity
			feedRepo.save(existingFeed);
			return "Feed updated successfully";
		} else {
			return "Feed not found";
		}
	}

}
