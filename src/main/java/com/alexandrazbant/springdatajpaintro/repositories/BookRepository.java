package com.alexandrazbant.springdatajpaintro.repositories;

import com.alexandrazbant.springdatajpaintro.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
