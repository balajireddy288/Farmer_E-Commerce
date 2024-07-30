package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;

	public Users registerUser(UserDTO userDto) {
		String email=userDto.getEmail();
		email = email.trim();
		if (userRepo.findByEmail(email) != null) {
			System.out.println(userRepo.findByEmail(email));
            throw new IllegalArgumentException("Email already in use");
        }
		if (!userDto.getPassword().equals(userDto.getCpassword())) {
            throw new IllegalArgumentException("Passwords do not match");
        }

        Users user = new Users();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setRole(userDto.getRole());
        user.setPassword(userDto.getPassword());
        user.setCpassword(userDto.getCpassword());

        return userRepo.save(user);
	}

	public Users login(UserDTO userDto) {
		 Users user = userRepo.findByEmail(userDto.getEmail());
		 System.out.print(userDto.getPassword() + user.getPassword());
	        if (user == null || !userDto.getPassword().equals(user.getPassword())) {
	        	System.out.println("no");
	            throw new IllegalArgumentException("Invalid email or password");
	        }

	        return user;
		
	}

	
}
