package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeServiceImpl;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
  @Autowired
  private EmployeeServiceImpl employeeServiceImpl;

  @GetMapping(value = {"/", "list", "listEmployee"})
  public String listEmployees(Model model) {
    model.addAttribute("employees", employeeServiceImpl.findAll());

    return "employees/listEmployee";
  }

  @GetMapping(value = {"/add", "addEmployee"})
  public String addEmployee(Model model) {

    model.addAttribute("employee", new Employee());

    return "employees/addEmployee";
  }
}
