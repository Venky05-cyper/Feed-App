package com.example.Feed.App.Bean;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class FeedBean {

	private String title;
	private String content;
	private String status; // "pending" or "approved"
	private int userId;
	private String username;
	private LocalDateTime createdDate;
}
