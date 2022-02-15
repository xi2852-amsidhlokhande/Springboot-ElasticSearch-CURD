package com.xebia.amsidh.springbootelasticsearch.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto implements Serializable {
    private String personId;
    private String personName;
    private String emailId;
    private Integer age;
    private Long mobileNumber;
}
