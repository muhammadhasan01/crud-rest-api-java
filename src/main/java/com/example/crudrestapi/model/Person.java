package com.example.crudrestapi.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Person {
    private final UUID id;
    private final String name;
}
