package com.klid.githooksspringboot;

import java.util.List;
import org.springframework.web.bind.annotation.*;

/** @author Ivan Kaptue */
@RestController("/persons")
public class HomeController {

  @PostMapping
  public long create(@RequestBody Person person) {
    var id = Data.generateId();
    person.setId(id);
    Data.PERSONS.add(person);
    return id;
  }

  @PutMapping("/{id}")
  public void update(@PathVariable long id, @RequestBody Person person) {
    var index = Data.indexOf(id);
    if (index == -1) {
      throw new PersonNotFoundException();
    }

    var savedPerson = new Person();
    savedPerson.setId(id);
    savedPerson.setName(person.getName());
    savedPerson.setEmail(person.getEmail());
    savedPerson.setPassword(person.getPassword());
    Data.PERSONS.add(index, savedPerson);
  }

  @GetMapping("/{id}")
  public Person find(@PathVariable long id) {
    return Data.PERSONS.stream()
        .filter(p -> p.getId() == id)
        .findFirst()
        .orElseThrow(PersonNotFoundException::new);
  }

  @GetMapping
  public List<Person> findAll() {
    return Data.PERSONS;
  }
}
