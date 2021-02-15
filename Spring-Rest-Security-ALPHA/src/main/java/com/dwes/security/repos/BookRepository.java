package com.dwes.security.repos;


import org.springframework.data.jpa.repository.JpaRepository;

import com.dwes.security.entities.Book;


public interface BookRepository extends JpaRepository<Book, Long> {
}