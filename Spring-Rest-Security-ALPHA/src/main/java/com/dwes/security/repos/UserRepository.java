package com.dwes.security.repos;

import org.springframework.data.repository.CrudRepository;

import com.dwes.security.entities.User;

public interface UserRepository extends CrudRepository<User,Long>{
	User findByUsername(String username);
}
