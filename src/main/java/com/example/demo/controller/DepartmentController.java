package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.service.DepartmentServiceImpl;

@Controller
@RequestMapping("/")
public class DepartmentController {
  @Autowired
  private DepartmentServiceImpl departmentServiceImpl;
  
  @RequestMapping(method = RequestMethod.GET)
  public String findAll(Model model) {
      model.addAttribute("departments", departmentServiceImpl.findAll());
      return "departments";
  }

}
