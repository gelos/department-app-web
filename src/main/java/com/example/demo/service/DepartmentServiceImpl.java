package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
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

  ClientFactory clientFactory =
      Configuration.builder().setBaseUri("http://localhost:8081").build().buildClientFactory();

  Client<Department> client = clientFactory.create(Department.class);

  public List<Department> findAll() {

    return StreamSupport.stream(client.getAll().spliterator(), false).collect(Collectors.toList());
  }

}
