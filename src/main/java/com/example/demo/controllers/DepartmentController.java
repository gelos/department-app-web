package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.service.DepartmentServiceImpl;

@Controller
public class DepartmentController {
  @Autowired
  private DepartmentServiceImpl departmentServiceImpl;
   
  @RequestMapping(value = {"/departments/list", "/departments", "/departments/departmentList"}, method = RequestMethod.GET)
  public String listDepartments(Model model) {
      model.addAttribute("departments", departmentServiceImpl.findAll());
      return "departments/departmentList";
  }

}
