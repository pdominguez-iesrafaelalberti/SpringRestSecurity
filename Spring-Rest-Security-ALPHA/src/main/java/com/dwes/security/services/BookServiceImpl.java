package com.dwes.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dwes.security.entities.Book;
import com.dwes.security.repos.BookRepository;

public class BookServiceImpl implements BookService{

	@Autowired
	BookRepository bookrepository;
	
	@Override
	public List<Book> getBooks() {
	
		 List<Book> books = bookrepository.findAll();
		return books;
	}

}
