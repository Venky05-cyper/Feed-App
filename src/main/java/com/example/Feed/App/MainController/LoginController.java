package com.example.Feed.App.MainController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Feed.App.Entity.AdminEntity;
import com.example.Feed.App.Entity.UserEntity;
import com.example.Feed.App.Repository.adminRepository;
import com.example.Feed.App.Repository.userRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private adminRepository adminRepo;

	@Autowired
	private userRepository userRepo;

	@PostMapping
	public ResponseEntity<Map<String, String>> login(@RequestParam String userName, @RequestParam String password) {

		// Check in Admin Table
		Optional<AdminEntity> admin = adminRepo.findByUserNameAndPassword(userName, password);
		if (admin.isPresent()) {
			Map<String, String> response = new HashMap<>();
			response.put("message", "Login successful");
			response.put("role", "admin");
			response.put("userId", String.valueOf(admin.get().getId())); // Add userId to response
			return ResponseEntity.ok(response);
		}

		// Check in User Table
		Optional<UserEntity> user = userRepo.findByUserNameAndPassword(userName, password);
		if (user.isPresent()) {
			Map<String, String> response = new HashMap<>();
			response.put("message", "Login successful");
			response.put("role", "user");
			response.put("userId", String.valueOf(user.get().getId())); // Add userId to response
			return ResponseEntity.ok(response);
		}

		// Invalid Credentials
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Invalid username or password"));
	}
}
