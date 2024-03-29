package com.alexandrazbant.springdatajpaintro.repositories;

import com.alexandrazbant.springdatajpaintro.domain.BookUuid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookUuidRepository extends JpaRepository<BookUuid, UUID> {
}
