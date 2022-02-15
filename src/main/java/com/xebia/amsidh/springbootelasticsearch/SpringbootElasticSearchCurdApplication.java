package com.xebia.amsidh.springbootelasticsearch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SpringbootElasticSearchCurdApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootElasticSearchCurdApplication.class, args);
		log.info("Spring-boot ElasticSearch CURD Application");
	}

}
