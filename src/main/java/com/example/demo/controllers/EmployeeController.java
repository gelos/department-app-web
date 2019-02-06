package com.example.demo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.model.Employee;
import com.example.demo.model.Department;
import com.example.demo.service.DepartmentServiceImpl;
import com.example.demo.service.EmployeeServiceImpl;

@Controller
@RequestMapping("/employees")
//@SessionAttributes("employee")
public class EmployeeController {
  @Autowired
  private EmployeeServiceImpl employeeServiceImpl;

  @Autowired
  private DepartmentServiceImpl departmentServiceImpl;

  private static final String VIEWS_EMPLOYEES_ADD_OR_UPDATE_FORM = "employees/addorUpdateEmployee";


  // Need for instantiate new employee for POST in listEmployee.
  @ModelAttribute(value = "employee")
  // public Employee newEmployee(@RequestParam("id") URI id)
  public Employee newEmployee() {
    // return employeeServiceImpl.findById(id);
    return new Employee();
  }

  @ModelAttribute(value = "departmentList")
  public List<Department> departmentList() {
    return departmentServiceImpl.findAll();
  }

  @GetMapping(value = {"/", "list", "listEmployee"})
  public String listEmployees(Model model) {
    model.addAttribute("employees", employeeServiceImpl.findAll());
    // model.addAttribute("employee", new Employee());
    return "employees/listEmployee";
  }

  @GetMapping(value = {"/add", "addEmployee"})
  public String addEmployee(Model model) {

    model.addAttribute("employee", new Employee());

    return VIEWS_EMPLOYEES_ADD_OR_UPDATE_FORM;
  }


  /*
   * @GetMapping(value = "/edit") public String getAddPageUser(Model model){
   * model.addAttribute("employee", new Employee()); //return VIEWS_EMPLOYEES_ADD_OR_UPDATE_FORM;
   * return "employees/listEmployee"; }
   */

  @PostMapping(value = "/edit")
  public String initEditForm(Model model, @ModelAttribute("employee") Employee employee) {
    model.addAttribute("departmentList", departmentList());

    System.err.println("EDIT " + employee.getId() + " " + employee.getFirstName() + " "
        + employee.getDepartment() + " " + employee);
    model.addAttribute("employee", employeeServiceImpl.findById(employee.getId()));
    System.err.println("EDIT " + employee.getId() + " " + employee.getFirstName() + " "
        + employee.getDepartment());
    return VIEWS_EMPLOYEES_ADD_OR_UPDATE_FORM;

  }

  @PostMapping(value = "/save")
  public String saveEmployee(Model model, @ModelAttribute("employee") Employee employee) {

    System.err.println("SAVE " + employee.getId() + " " + employee.getFirstName() + " "
        + employee.getDepartment());
    System.err.println("SAVE " + employee + "  " + employee.getDepartment().getId());
    employee.setDepartment(departmentServiceImpl.findById(employee.getDepartment().getId()));
    System.err.println(
        "SAVE " + employee.getId() + " " + employee + "  " + employee.getDepartment().getId());
    employeeServiceImpl.save(employee);
    return VIEWS_EMPLOYEES_ADD_OR_UPDATE_FORM;

  }


}
