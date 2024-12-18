package com.example.Feed.App.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class FeedEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "user_id")
	private Integer userId;
	private String username; // Include username
	private String title;
	private String content;
	private String status;
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	// "pending" or "approved"
	// User who submitted the feed
}
