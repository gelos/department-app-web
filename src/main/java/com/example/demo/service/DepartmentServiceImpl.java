package com.example.demo.service;

import java.net.URI;
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

  @Value("${api.rest.basepath}")
  private String basePath;
  /*
   * @Value("${resource.departments}/{id}") private String idResource;
   */

  private ClientFactory clientFactory;
  private Client<Department> client;

  public DepartmentServiceImpl() {
    System.err.println(basePath);
    this.clientFactory = Configuration.builder().setBaseUri("http://localhost:8081/api/rest/v1")
        .build().buildClientFactory();
    this.client = this.clientFactory.create(Department.class);
  }

  /*
   * ClientFactory clientFactory =
   * Configuration.builder().setBaseUri(basePath).build().buildClientFactory();
   */
  // Configuration.builder().setBaseUri("http://localhost:8081").build().buildClientFactory();

  // Client<Department> client = clientFactory.create(Department.class);

  public List<Department> findAll() {

    return StreamSupport.stream(this.client.getAll().spliterator(), false)
        .collect(Collectors.toList());
  }

  public Department findById(URI departmentId) {

    return this.client.get(departmentId);

  }

}
