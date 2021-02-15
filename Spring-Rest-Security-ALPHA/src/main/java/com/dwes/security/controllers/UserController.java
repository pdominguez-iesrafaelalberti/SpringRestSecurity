package com.dwes.security.controllers;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dwes.security.entities.User;
import com.dwes.security.services.UserService;

@Validated
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	

	@PostMapping("/user/register")
	public ResponseEntity<UserResponse> create(@Valid @RequestBody User user){
		System.out.println("##>"+ user.getUsername());
		
		User saved = userService.save(user);

		return ResponseEntity.status(HttpStatus.CREATED).body(new UserResponse(saved.getUsername(), saved.getRole()));
	}
	
	/**
	 * CLASE UserResponse para devolver la RESPUESTA
	 * @author 
	 *
	 */
	public class UserResponse{
		
		String username;
		String role;
		

		public UserResponse(String username, String role) {
			this.username = username;
			this.role = role;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}
		
		
	}
}
