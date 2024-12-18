package com.example.Feed.App.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Feed.App.Bean.userBean;
import com.example.Feed.App.Entity.UserEntity;
import com.example.Feed.App.Repository.userRepository;
import com.example.Feed.App.service.userService;

@Service
public class userServiceImp implements userService {

	@Autowired
	userRepository userRepo;

	@Override
	public String saveuserData(userBean request) {
		UserEntity user = new UserEntity();
		user.setUserName(request.getUserName());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setPhoneNumbers(request.getPhoneNumbers());
		user.setRole(request.getRole());
		userRepo.save(user);
		return "user data saved!";
	}

	@Override
	public String updateUserData(int userId, userBean request) {
		if (userRepo.existsById(userId)) {
			UserEntity existingUser = userRepo.findById(userId).get();
			existingUser.setUserName(request.getUserName());
			existingUser.setPassword(request.getPassword());
			existingUser.setEmail(request.getEmail());
			existingUser.setPhoneNumbers(request.getPhoneNumbers());
			existingUser.setRole(request.getRole());
			userRepo.save(existingUser);
			return "User updated successfully!";
		} else {
			return "User not found!";
		}
	}

	@Override
	public String deleteUserData(int userId) {
		if (userRepo.existsById(userId)) {
			userRepo.deleteById(userId);
			return "User deleted successfully!";
		} else {
			return "User not found!";
		}
	}

	@Override
	public UserEntity findById(Long id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id);
	}

}
