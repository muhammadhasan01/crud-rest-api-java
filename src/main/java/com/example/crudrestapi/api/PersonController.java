package com.example.crudrestapi.api;

import com.example.crudrestapi.model.Person;
import com.example.crudrestapi.service.PersonService;

public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    public void addPerson(Person person) {
        personService.addPerson(person);
    }
}
