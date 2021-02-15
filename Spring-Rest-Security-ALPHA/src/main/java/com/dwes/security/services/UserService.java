package com.dwes.security.services;

import com.dwes.security.entities.User;

public interface UserService {
	User save(User user);
	User findByUsername(String username);
}
