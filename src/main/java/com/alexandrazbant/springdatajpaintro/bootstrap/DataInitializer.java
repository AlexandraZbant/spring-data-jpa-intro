package com.alexandrazbant.springdatajpaintro.bootstrap;

import com.alexandrazbant.springdatajpaintro.domain.Book;
import com.alexandrazbant.springdatajpaintro.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Book bookDDD = new Book("Domain Driven Design", "123", "RandomHouse", null);
        Book saveDDD = bookRepository.save(bookDDD);

        Book bookSIA = new Book("Spring In Action", "15412", "O'Reilly", null);
        Book saveSIA = bookRepository.save(bookSIA);

        bookRepository.findAll().forEach(book -> {
            System.out.println("Book Id: "+ book.getId());
            System.out.println("Book Title: "+ book.getTitle());

        });

    }
}
