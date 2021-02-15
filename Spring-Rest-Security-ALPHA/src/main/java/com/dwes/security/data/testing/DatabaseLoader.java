package com.dwes.security.data.testing;

import java.math.BigDecimal;

import org.apache.catalina.Context;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.dwes.security.entities.Book;
import com.dwes.security.entities.User;
import com.dwes.security.repos.BookRepository;
import com.dwes.security.repos.UserRepository;
import com.dwes.security.servlet.MyServletV1;

@Component
public class DatabaseLoader implements ApplicationRunner{
	
	@Autowired
	BookRepository bookrepository;
	
	@Autowired
	UserRepository userRepository;
	

	@Override
	public void run(ApplicationArguments args) throws Exception {
		/**
		Tomcat tomcat = new Tomcat();
	     tomcat.setPort(8085);
	     tomcat.getConnector();
		
	     Context ctx = tomcat.addContext("", null);
	     Wrapper servlet = Tomcat.addServlet(ctx, "myServlet", new MyServletV1());
	     servlet.setLoadOnStartup(1);
	     servlet.addMapping("/*");

	     tomcat.start();
*/
		
		//
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		userRepository.deleteAll();
		//Creo los usuarios
		userRepository.save(new User("admin", encoder.encode("admin"),"ADMIN"));
    	userRepository.save(new User("usuario", encoder.encode("usuario"),"USER"));
    	
    	
    	bookrepository.save(new Book("A Guide to the Bodhisattva Way of Life", "Santideva", new BigDecimal("15.41")));
    	bookrepository.save(new Book("The Life-Changing Magic of Tidying Up", "Marie Kondo", new BigDecimal("9.69")));
    	bookrepository.save(new Book("Refactoring: Improving the Design of Existing Code", "Martin Fowler", new BigDecimal("47.99")));
		
		
	}
	
	
	
	 

   
}
