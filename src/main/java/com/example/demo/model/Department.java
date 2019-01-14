package com.example.demo.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown=true)
public class Department extends BaseEntity{
   
  public Department(String name) {
    this.name = name;
  }
  
  private String name;
  
  //private List<Employee> employees;

}
