package com.example.Feed.App.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Feed.App.Entity.FeedEntity;

public interface FeedRepository extends JpaRepository<FeedEntity, Integer> {

	List<FeedEntity> findByStatus(String string);

	List<FeedEntity> findByUserId(Integer userId);

}
