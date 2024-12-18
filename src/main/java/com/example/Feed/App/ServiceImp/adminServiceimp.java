package com.example.Feed.App.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Feed.App.Bean.adminBean;
import com.example.Feed.App.Entity.AdminEntity;
import com.example.Feed.App.Repository.adminRepository;
import com.example.Feed.App.service.adminService;

@Service
public class adminServiceimp implements adminService {

	@Autowired
	adminRepository adminRepo;

	@Override
	public String saveData(adminBean request) {
		AdminEntity admin = new AdminEntity();
		admin.setEmail(request.getEmail());
		admin.setPassword(request.getPassword());
		admin.setPhoneNumbers(request.getPhoneNumbers());
		admin.setRole(request.getRole());
		admin.setUserName(request.getUserName());
		adminRepo.save(admin);
		return "user data saved!";
	}

}
