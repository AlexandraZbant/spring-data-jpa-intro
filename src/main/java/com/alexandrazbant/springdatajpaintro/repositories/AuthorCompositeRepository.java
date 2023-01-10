package com.alexandrazbant.springdatajpaintro.repositories;

import com.alexandrazbant.springdatajpaintro.domain.composite.AuthorComposite;
import com.alexandrazbant.springdatajpaintro.domain.composite.NameId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorCompositeRepository extends JpaRepository<AuthorComposite, NameId> {
}
