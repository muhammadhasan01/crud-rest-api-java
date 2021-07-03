package com.example.crudrestapi.dao;

import com.example.crudrestapi.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
        final String sql = "INSERT INTO PERSON (id, name) VALUES (?, ?)";
        String name = person.getName();
        Object[] args = new Object[]{id, name};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public List<Person> selectAllPeople() {
        final String sql = "SELECT id, name FROM person";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            return new Person(id, name);
        });
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        final String sql = "SELECT id, name FROM PERSON WHERE id = ?";
        Object[] args = new Object[]{id};
        Person person = jdbcTemplate.queryForObject(sql, args, (resultSet, i) -> {
            UUID personId = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            return new Person(personId, name);
        });
        return Optional.ofNullable(person);
    }

    @Override
    public int deletePersonById(UUID id) {
        final String sql = "DELETE FROM PERSON WHERE id = ?";
        Object[] args = new Object[]{id};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        final String sql = "UPDATE PERSON SET name = ? WHERE id = ?";
        String name = person.getName();
        Object[] args = new Object[]{name, id};
        return jdbcTemplate.update(sql, args);
    }
}
