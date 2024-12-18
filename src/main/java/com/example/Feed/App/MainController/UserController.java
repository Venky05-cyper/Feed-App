package com.example.Feed.App.MainController;

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

import com.example.Feed.App.Bean.userBean;
import com.example.Feed.App.Entity.UserEntity;
import com.example.Feed.App.service.userService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	userService userServ;

	@PostMapping("/saveUserData")
	public String saveuserData(@RequestBody userBean request) {
		return userServ.saveuserData(request);
	}

	@PutMapping("/updateUserData/{userId}")
	public String updateUserData(@PathVariable int userId, @RequestBody userBean request) {
		return userServ.updateUserData(userId, request);
	}

	// Delete User Data
	@DeleteMapping("/deleteUserData/{userId}")
	public String deleteUserData(@PathVariable int userId) {
		return userServ.deleteUserData(userId);
	}

	@GetMapping("/users/{id}")
	public UserEntity getUserById(@PathVariable Long id) {
		return userServ.findById(id);
	}
}
