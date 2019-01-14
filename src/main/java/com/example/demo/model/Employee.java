package com.example.demo.model;

import java.util.Date;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor(access=AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Employee extends BaseEntity{
 
  private String firstName;
  
  private String patronymic;
  
  private String secondName;
  
  private Date bornDate;
  
  private int salary;
  
  private Department department;
  
}
