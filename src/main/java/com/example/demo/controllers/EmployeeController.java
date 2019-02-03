package com.example.demo.controllers;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.service.EmployeeServiceImpl;

@Controller
public class EmployeeController {
  @Autowired
  private EmployeeServiceImpl employeeServiceImpl;
   
  @RequestMapping(value = {"/employees/list", "/employees", "employees/employeeList"}, method = RequestMethod.GET)
  public String listEmployees(Model model) {
      model.addAttribute("employees", employeeServiceImpl.findAll());
      model.addAttribute("localDate", LocalDate.now());
      return "employees/employeeList";
  }

}
