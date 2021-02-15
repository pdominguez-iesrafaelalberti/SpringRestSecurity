package com.dwes.security.services;

import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dwes.security.entities.User;
import com.dwes.security.repos.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		Iterable<User> users = userRepository.findAll();
		User user = StreamSupport
				.stream(users.spliterator(), false)
				.filter(u-> u.getUsername().contentEquals(username))
				.findFirst().orElse(null);
		return user;
	}

	
}
