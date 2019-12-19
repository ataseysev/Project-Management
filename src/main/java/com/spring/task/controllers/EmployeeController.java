package com.spring.task.controllers;


import com.spring.task.repository.EmployeeRepository;
import com.spring.task.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository empRep;

    @GetMapping
    public String displayEmployees(Model model){
        List<Employee> employees = empRep.findAll();
        model.addAttribute("employees",employees);
        return "employees/list-employees";
    }

    @GetMapping("/new")
    public String displayEmployeeForm(Model model){
        Employee aEmployee = new Employee();
        model.addAttribute("employee",aEmployee);
        return "employees/new-employee";
    }

    @PostMapping(value = "/save2")
    public String createEmployee(Employee employee, Model model) {
        // this should handle saving to the database..
        empRep.save(employee);
        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/new";
    }

// basically employee object is postted to the create employee through form method above

}
