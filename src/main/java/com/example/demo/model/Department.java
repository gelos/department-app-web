package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import uk.co.blackpepper.bowman.annotation.RemoteResource;

@RemoteResource("/departments")
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown=true)
public class Department extends BaseEntity{
  
  private String name;
 
  private Double avgSalary;

}
