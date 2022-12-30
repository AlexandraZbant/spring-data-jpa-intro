package com.alexandrazbant.springdatajpaintro;

import com.alexandrazbant.springdatajpaintro.domain.Book;
import com.alexandrazbant.springdatajpaintro.repositories.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ComponentScan(basePackages = "com.alexandrazbant.springdatajpaintro.bootstrap")
@DataJpaTest
public class SpringDataJpaTests {

    @Autowired
    BookRepository bookRepository;

    @Commit
    @Order(1)
    @Test
    void testBookRepository(){

        long countBefore = bookRepository.count();

        bookRepository.save(new Book("MyBook", "12345678", "Publisher"));

        long countAfter = bookRepository.count();

        assertThat (countBefore).isLessThan(countAfter);
    }

    @Order(2)
    @Test
    void testBookRepositoryTransactional(){

        long countBefore = bookRepository.count();

        assertThat (countBefore).isEqualTo(3);
    }
}
