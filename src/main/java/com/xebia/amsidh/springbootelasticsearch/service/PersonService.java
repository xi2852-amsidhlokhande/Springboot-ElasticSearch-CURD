package com.xebia.amsidh.springbootelasticsearch.service;

import com.xebia.amsidh.springbootelasticsearch.entity.Person;

public interface PersonService {
    Person savePerson(Person person);
    Person getPersonByPersonId(String personId);
    Person updatePerson(String personId, Person person);

}
