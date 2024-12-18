package com.example.Feed.App.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Feed.App.Entity.UserEntity;

public interface userRepository extends JpaRepository<UserEntity, Integer> {

	Optional<UserEntity> findByUserNameAndPassword(String userName, String password);

	UserEntity findById(Long id);

}
