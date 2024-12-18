package com.example.Feed.App.service;

import com.example.Feed.App.Bean.userBean;
import com.example.Feed.App.Entity.UserEntity;

public interface userService {

	String saveuserData(userBean request);

	String updateUserData(int userId, userBean request);

	String deleteUserData(int userId);

	UserEntity findById(Long id);

}
