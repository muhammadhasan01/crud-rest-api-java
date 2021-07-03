package com.example.crudrestapi.dao;

import com.example.crudrestapi.model.Person;

import java.util.List;
import java.util.UUID;

/**
 * The actual interface/contract for everyone
 * that wishes to implement this interface
 */
public interface PersonDao {

    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> selectAllPeople();
}
