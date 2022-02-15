package com.xebia.amsidh.springbootelasticsearch.repository;

import com.xebia.amsidh.springbootelasticsearch.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface PersonRepository extends ElasticsearchRepository<Person, String> {

    Page<Person> findByPersonName(String personName, Pageable pageable);

}
