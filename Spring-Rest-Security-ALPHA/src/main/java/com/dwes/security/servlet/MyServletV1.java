package com.dwes.security.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.dwes.security.entities.Book;
import com.dwes.security.repos.BookRepository;
import com.dwes.security.services.BookService;
import com.dwes.security.services.BookServiceImpl;


public class MyServletV1 extends HttpServlet {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	    private BookRepository repository;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        if (req.getRequestURI().equals("/libros")) {
            resp.setContentType("text/html");

        String html = "<html><head></head><body><h1>Welcome!</h1><p>This is a very cool page!</p>";
        /*      
            List<Book> books = ;*/
           // html +=createTABLEBookHTML();
            html +="</body></html>";
            
            resp.getWriter().print(html);
        }
        else {
            throw new IllegalStateException("Help, I don't know what to do with this url");
        }
    }


	private String createTABLEBookHTML(List<Book> books ) {
		String ret = "";
		
		if(books != null) {

			ret += "<table style='width:100%'>";
			ret += " <tr>";
			ret += "   <th>Autor</th>";
			ret += "   <th>Nombre</th>";
			ret += "  <th>Precio</th>";
			ret += "</tr>";
			for(Book book:books) {
			ret += " <tr>";
			ret += "<td>"+book.getAuthor()+"</td>";
			ret += "<td>"+book.getName()+"</td>";
			ret += " <td>"+book.getPrice()+"</td>";
			ret += "	  </tr>";
			}
			ret += "</table>";
		}else {
			ret += "<mark>NO TABLE.</mark>";
		}
		
		
		return ret;

	}

}
