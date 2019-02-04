package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.service.DepartmentServiceImpl;

@Controller
@RequestMapping(value = "/departments")
public class DepartmentController {
  @Autowired
  private DepartmentServiceImpl departmentServiceImpl;

  @GetMapping(value = {"/", "/list", "/listDepartments"})
  public String listDepartments(Model model) {
    model.addAttribute("departments", departmentServiceImpl.findAll());
    return "departments/listDepartment";
  }

}
