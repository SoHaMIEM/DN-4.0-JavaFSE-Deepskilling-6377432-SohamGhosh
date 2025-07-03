package com.library;
import com.library.service.BookService;
import com.library.repository.BookRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */

public class App {
   
	public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = context.getBean("bookService", BookService.class);
        BookRepository bookRepository = (BookRepository) context.getBean("bookRepository");
        bookService.addBook("Harry Potter");
        bookRepository.saveBook("Harry Potter");
    }
}
