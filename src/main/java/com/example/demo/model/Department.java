package com.example.demo.model;

import java.net.URI;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import uk.co.blackpepper.bowman.annotation.LinkedResource;
import uk.co.blackpepper.bowman.annotation.RemoteResource;
import uk.co.blackpepper.bowman.annotation.ResourceId;

@RemoteResource("/departments")
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown=true)
//public class Department extends BaseEntity{
public class Department {
    
  private URI id;

  @ResourceId public URI getId() { return id; }
  
  //@LinkedResource public String getStringId() { return id.getPath(); }
  
  private String name;
 
  //@ResourceId public long getId() { return this.getId(); }
  
  //private List<Employee> employees;

}
