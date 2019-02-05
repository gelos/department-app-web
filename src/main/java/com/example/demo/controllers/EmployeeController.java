package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeServiceImpl;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
  @Autowired
  private EmployeeServiceImpl employeeServiceImpl;

  private static final String VIEWS_EMPLOYEES_ADD_OR_UPDATE_FORM = "employees/addorUpdateEmployee";


  // Need for instantiate new employee for POST in listEmployee.
  @ModelAttribute(value = "employee")
  public Employee newEmployee()
  {
      return new Employee();
  }
  
  @GetMapping(value = {"/", "list", "listEmployee"})
  public String listEmployees(Model model) {
    model.addAttribute("employees", employeeServiceImpl.findAll());
    //model.addAttribute("employee", new Employee());
    return "employees/listEmployee";
  }

  @GetMapping(value = {"/add", "addEmployee"})
  public String addEmployee(Model model) {

    model.addAttribute("employee", new Employee());

    return VIEWS_EMPLOYEES_ADD_OR_UPDATE_FORM;
  }

  
/*  @GetMapping(value = "/edit")
  public String getAddPageUser(Model model){
      model.addAttribute("employee", new Employee());
      //return VIEWS_EMPLOYEES_ADD_OR_UPDATE_FORM;
      return "employees/listEmployee";
  }  */
  
  @PostMapping(value = "/edit")
  //public String initEditForm(@ModelAttribute("employee") Employee employee, final Model model) {
  public String initEditForm(Model model, @ModelAttribute("employee") Employee employee) {

      System.err.println("THIS IS A TEST!!!" + employee.getId() + " " + employee.getFirstName());

  //    model.addAttribute("employee", employee);

      return VIEWS_EMPLOYEES_ADD_OR_UPDATE_FORM;
  }
/*  
  @GetMapping(value = "/{employeeId}/edit")
  public String initUpdateOwnerForm(@PathVariable("employeeId") Resource<Employee> employee, Model model) {
    System.err.println("in proc");
    //Employee employee = this.employeeServiceImpl.findById(employeeId.get);
    
    model.addAttribute(employee);
    return VIEWS_EMPLOYEES_ADD_OR_UPDATE_FORM;
  }*/

}
