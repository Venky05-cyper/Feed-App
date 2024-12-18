package com.example.Feed.App.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String userName;
	private String password;
	private String email;
	private String phoneNumbers;
	private String role;

	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

}
