package com.example.crudrestapi.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
public class Person {
    private final UUID id;
    @NotBlank
    private final String name;
}
