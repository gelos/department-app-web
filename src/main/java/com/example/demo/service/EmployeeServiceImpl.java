package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.stereotype.Service;
import com.example.demo.model.Employee;
import uk.co.blackpepper.bowman.Client;
import uk.co.blackpepper.bowman.ClientFactory;
import uk.co.blackpepper.bowman.Configuration;

@Service
public class EmployeeServiceImpl {

  private ClientFactory clientFactory;
  private Client<Employee> client;

  public EmployeeServiceImpl() {
    this.clientFactory = Configuration.builder().setBaseUri("http://localhost:8081/api/rest/v1").build().buildClientFactory();
    this.client = this.clientFactory.create(Employee.class);
  }

  public List<Employee> findAll() {

    return StreamSupport.stream(this.client.getAll().spliterator(), false).collect(Collectors.toList());
  }

}
