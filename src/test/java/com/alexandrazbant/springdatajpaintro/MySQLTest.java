package com.alexandrazbant.springdatajpaintro.integration;

import com.alexandrazbant.springdatajpaintro.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@ComponentScan(basePackages = "com.alexandrazbant.springdatajpaintro.bootstrap")
public class MySQLTest {

    @Autowired
    BookRepository bookRepository;

    void testMySQL(){
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(2);
    }
}
