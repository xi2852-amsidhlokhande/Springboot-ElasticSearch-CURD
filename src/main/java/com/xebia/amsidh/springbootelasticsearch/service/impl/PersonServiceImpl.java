package com.xebia.amsidh.springbootelasticsearch.service.impl;

import com.xebia.amsidh.springbootelasticsearch.entity.Person;
import com.xebia.amsidh.springbootelasticsearch.repository.PersonRepository;
import com.xebia.amsidh.springbootelasticsearch.service.PersonService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static java.util.Optional.ofNullable;

@Data
@Service
@Slf4j
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public Person savePerson(Person person) {
        log.info("Saving person to elastic search index with {}", person);
        return this.personRepository.save(person);
    }

    @Override
    public Person getPersonByPersonId(String personId) {
        log.info("Get Person by PersonName {}", personId);
        return this.personRepository.findById(personId).orElseThrow(() -> new RuntimeException("Person with PersonId " + personId + " not found."));
    }

    @Override
    public Person updatePerson(String personId, Person person) {
        log.info("Update the Person with personId {}", personId);
        Person oldPerson = getPersonByPersonId(personId);
        ofNullable(person.getPersonName()).ifPresent(oldPerson::setPersonName);
        ofNullable(person.getAge()).ifPresent(oldPerson::setAge);
        ofNullable(person.getEmailId()).ifPresent(oldPerson::setEmailId);
        ofNullable(person.getMobileNumber()).ifPresent(oldPerson::setMobileNumber);
        return this.personRepository.save(oldPerson);
    }
}
