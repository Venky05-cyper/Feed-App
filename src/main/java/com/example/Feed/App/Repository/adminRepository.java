package com.example.Feed.App.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Feed.App.Entity.AdminEntity;

public interface adminRepository extends JpaRepository<AdminEntity, Integer> {

	Optional<AdminEntity> findByUserNameAndPassword(String userName, String password);

}
