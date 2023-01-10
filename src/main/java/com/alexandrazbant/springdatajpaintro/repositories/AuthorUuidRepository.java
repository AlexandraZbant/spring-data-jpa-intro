package com.alexandrazbant.springdatajpaintro.repositories;

import com.alexandrazbant.springdatajpaintro.domain.AuthorUuid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorUuidRepository extends JpaRepository<AuthorUuid, UUID> {
}
