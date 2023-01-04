package com.alexandrazbant.springdatajpaintro.bootstrap;

import com.alexandrazbant.springdatajpaintro.domain.AuthorUuid;
import com.alexandrazbant.springdatajpaintro.domain.Book;
import com.alexandrazbant.springdatajpaintro.repositories.AuthorUuidRepository;
import com.alexandrazbant.springdatajpaintro.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorUuidRepository authorUuidRepository;


    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();
        authorUuidRepository.deleteAll();

        Book bookDDD = new Book("Domain Driven Design", "123", "RandomHouse", null);
        Book saveDDD = bookRepository.save(bookDDD);

        Book bookSIA = new Book("Spring In Action", "15412", "O'Reilly", null);
        Book saveSIA = bookRepository.save(bookSIA);

        bookRepository.findAll().forEach(book -> {
            System.out.println("Book Id: "+ book.getId());
            System.out.println("Book Title: "+ book.getTitle());
        });

        AuthorUuid authorUuid = new AuthorUuid();
        authorUuid.setFirstName("Joe");
        authorUuid.setLastName("Buck");
        AuthorUuid savedAuthor = authorUuidRepository.save(authorUuid);
        System.out.printf("Saved Author UUID: " + savedAuthor.getId());

    }
}
