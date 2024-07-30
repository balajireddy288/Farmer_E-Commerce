package com.example.demo.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Users;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
	
	@Autowired
	private UserService user;
	
	@GetMapping("/")
	public void home()
	{
		System.out.print("HI");
	}
	
	@RequestMapping("/register")
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<?> register(@RequestBody UserDTO userDto){
		try {
			System.out.print("In iy");
            if (userDto.getName() == null || userDto.getEmail() == null || userDto.getRole() == null || userDto.getPassword() == null || userDto.getCpassword() == null) {
                return ResponseEntity.status(422).body("Enter all the details");
            }

            Users newUser = user.registerUser(userDto);
            return ResponseEntity.status(201).body(newUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(422).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error");
        }
		
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<?> login(@RequestBody UserDTO userDto){
			try {
				Users u=user.login(userDto);
				 return ResponseEntity.status(201).body(u);
				
			}catch (IllegalArgumentException e) {
	            return ResponseEntity.status(422).body(e.getMessage());
	        } catch (Exception e) {
	            return ResponseEntity.status(500).body("Internal Server Error");
	        }
		
	}
	
	
}
