package com.example.demo.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.demo.model.Department;

@Service
public class DepartmentServiceImpl {
  @Autowired
  private RestTemplate restTemplate;

  @Value("${resource.departments}")
  private String resource;
  @Value("${resource.departments}/{id}")
  private String idResource;

  public List<Department> findAll() {
    return Arrays.stream(restTemplate.getForObject(resource, Department[].class))
        .collect(Collectors.toList());
  }

}
