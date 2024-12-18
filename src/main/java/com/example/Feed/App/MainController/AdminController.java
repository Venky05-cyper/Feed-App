package com.example.Feed.App.MainController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Feed.App.Bean.adminBean;
import com.example.Feed.App.service.adminService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	adminService adminServ;

	@PostMapping("/saveAdminData")
	public String saveData(@RequestBody adminBean request) {
		return adminServ.saveData(request);
	}

}
