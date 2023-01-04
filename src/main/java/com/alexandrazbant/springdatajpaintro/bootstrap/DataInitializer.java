package com.alexandrazbant.springdatajpaintro.bootstrap;

import com.alexandrazbant.springdatajpaintro.domain.AuthorUuid;
import com.alexandrazbant.springdatajpaintro.domain.Book;
import com.alexandrazbant.springdatajpaintro.domain.BookUuid;
import com.alexandrazbant.springdatajpaintro.repositories.AuthorUuidRepository;
import com.alexandrazbant.springdatajpaintro.repositories.BookRepository;
import com.alexandrazbant.springdatajpaintro.repositories.BookUuidRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorUuidRepository authorUuidRepository;
    private final BookUuidRepository bookUuidRepository;


    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();
        authorUuidRepository.deleteAll();
        bookUuidRepository.deleteAll();

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
        System.out.println("Saved Author UUID: " + savedAuthor.getId());

        BookUuid bookUuid = new BookUuid();
        bookUuid.setTitle("All About UUIDs");
        BookUuid savedBook = bookUuidRepository.save(bookUuid);
        System.out.println("Saved Book UUID: " + savedBook.getId());

    }
}
