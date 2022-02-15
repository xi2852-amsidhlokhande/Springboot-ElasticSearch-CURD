package com.xebia.amsidh.springbootelasticsearch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.WriteTypeHint;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "person", writeTypeHint = WriteTypeHint.FALSE, createIndex = false)
public class Person implements Serializable {
    @Id
    private String personId;
    private String personName;
    private String emailId;
    private Integer age;
    private Long mobileNumber;
}
