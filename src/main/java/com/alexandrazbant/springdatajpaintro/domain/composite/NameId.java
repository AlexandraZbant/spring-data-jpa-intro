package com.alexandrazbant.springdatajpaintro.domain.composite;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class NameId implements Serializable {

    private String firstName;
    private String lastName;
}