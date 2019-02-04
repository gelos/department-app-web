package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeServiceImpl;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
  @Autowired
  private EmployeeServiceImpl employeeServiceImpl;

  private static final String VIEWS_EMPLOYEES_ADD_OR_UPDATE_FORM = "employees/addorUpdateEmployee";

  @GetMapping(value = {"/", "list", "listEmployee"})
  public String listEmployees(Model model) {
    model.addAttribute("employees", employeeServiceImpl.findAll());

    return "employees/listEmployee";
  }

  @GetMapping(value = {"/add", "addEmployee"})
  public String addEmployee(Model model) {

    model.addAttribute("employee", new Employee());

    return VIEWS_EMPLOYEES_ADD_OR_UPDATE_FORM;
  }

  @GetMapping(value = "/{employeeId}/edit")
  public String initUpdateOwnerForm(@PathVariable("employeeId") Resource<Employee> employee, Model model) {
    System.err.println("in proc");
    //Employee employee = this.employeeServiceImpl.findById(employeeId.get);
    
    model.addAttribute(employee);
    return VIEWS_EMPLOYEES_ADD_OR_UPDATE_FORM;
  }

}
