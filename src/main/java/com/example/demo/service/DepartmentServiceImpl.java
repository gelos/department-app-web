package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.demo.model.Department;
import uk.co.blackpepper.bowman.Client;
import uk.co.blackpepper.bowman.ClientFactory;
import uk.co.blackpepper.bowman.Configuration;

@Service
public class DepartmentServiceImpl {
  
  @Value("${resource.departments}")
  private String resource;
  @Value("${resource.departments}/{id}")
  private String idResource;
  
  // @Autowired
  // private RestTemplate restTemplate;

  // @Autowired
  // private ClientFactory clientFactory;

  
  ClientFactory clientFactory =
      Configuration.builder().setBaseUri("http://localhost:8081").build().buildClientFactory();

  Client<Department> client = clientFactory.create(Department.class);

    public List<Department> findAll() {

    // Customer customer = client.getAll();

//    return Arrays.stream(restTemplate.getForObject(resource, Department[].class))
    // .collect(Collectors.toList());
      
    return StreamSupport.stream(client.getAll().spliterator(), false).collect(Collectors.toList());
    //return Lists.<Object>newArrayList(client.getAll());
  }

}
