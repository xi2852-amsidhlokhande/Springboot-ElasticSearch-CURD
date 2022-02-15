package com.xebia.amsidh.springbootelasticsearch.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xebia.amsidh.springbootelasticsearch.dto.PersonDto;
import com.xebia.amsidh.springbootelasticsearch.entity.Person;
import com.xebia.amsidh.springbootelasticsearch.service.PersonService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/persons")
@Slf4j
public class PersonController {

    private final PersonService personService;
    ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/{personId}")
    public PersonDto findPersonByPersonId(@PathVariable("personId") String personId) {
        log.info("Inside findPersonByPersonId method of controller PersonController with personId {}", personId);
        return objectMapper.convertValue(this.personService.getPersonByPersonId(personId), PersonDto.class);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public PersonDto savePerson(@RequestBody PersonDto personDto) {
        log.info("Inside savePerson method of controller PersonController with {}", personDto);
        Person person = personService.savePerson(objectMapper.convertValue(personDto, Person.class));
        return objectMapper.convertValue(person, PersonDto.class);
    }

    @PutMapping(value = "/{personId}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public PersonDto updatePerson(@PathVariable("personId") String personId, @RequestBody PersonDto personDto) {
        log.info("Inside updatePerson method of controller PersonController for personId {} and person {}", personId, personDto);
        Person updatePerson = personService.updatePerson(personId, objectMapper.convertValue(personDto, Person.class));
        return objectMapper.convertValue(updatePerson, PersonDto.class);
    }

}
