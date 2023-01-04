package com.alexandrazbant.springdatajpaintro;

import com.alexandrazbant.springdatajpaintro.domain.AuthorUuid;
import com.alexandrazbant.springdatajpaintro.domain.BookUuid;
import com.alexandrazbant.springdatajpaintro.repositories.AuthorUuidRepository;
import com.alexandrazbant.springdatajpaintro.repositories.BookRepository;
import com.alexandrazbant.springdatajpaintro.repositories.BookUuidRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ActiveProfiles("local")
@DataJpaTest
@ComponentScan(basePackages = "com.alexandrazbant.springdatajpaintro.bootstrap")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MySQLTest {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookUuidRepository bookUuidRepository;
    @Autowired
    AuthorUuidRepository authorUuidRepository;

    @Test
    void testMySQL(){
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(2);
    }
    @Test
    void testBookUUID(){
        BookUuid bookUuid = bookUuidRepository.save(new BookUuid());
        assertThat(bookUuid).isNotNull();
        assertThat(bookUuid.getId()).isNotNull();

        Optional<BookUuid> fetched = bookUuidRepository.findById(bookUuid.getId());
        assertThat(fetched).isNotNull();
    }
    @Test
    void testAuthorUUID(){
        AuthorUuid authorUuid = authorUuidRepository.save(new AuthorUuid());
        assertThat(authorUuid).isNotNull();
        assertThat(authorUuid.getId()).isNotNull();

        Optional<AuthorUuid> fetched = authorUuidRepository.findById(authorUuid.getId());
        assertThat(fetched).isNotNull();
    }

}
