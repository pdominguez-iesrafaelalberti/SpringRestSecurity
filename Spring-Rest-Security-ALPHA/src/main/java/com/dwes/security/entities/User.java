package com.dwes.security.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.dwes.security.error.validator.label.RoleLabel;



@Entity
@Table(name="Users")
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Size(min=4, max=8)
	@NotEmpty(message = "Please provide a name")
	@Column(unique = true)
	private String username;
	
	@NotEmpty(message = "Please provide a password")
	private String password;
	
	@RoleLabel
	@NotEmpty(message= "Please provide a rol")
	private String role;
	
	protected User() {}
	

	public User(@Size(min = 5, max = 8) @NotEmpty(message = "Please provide a name") String username,
			@NotEmpty(message = "Please provide a password") String password,
			@NotEmpty(message = "Please provide a rol") String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
