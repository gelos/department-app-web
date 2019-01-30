package com.example.demo.model;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import uk.co.blackpepper.bowman.annotation.RemoteResource;

@RemoteResource("/employees")
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown=true)
public class Employee extends BaseEntity{
 
  private String firstName;
  
  private String patronymic;
  
  private String secondName;
  
  // Add to support String to LocalDate deserialization
 @JsonDeserialize(using = LocalDateDeserializer.class)  
  private LocalDate bornDate;
  
  private int salary;
  
  private Department department;
  
}
