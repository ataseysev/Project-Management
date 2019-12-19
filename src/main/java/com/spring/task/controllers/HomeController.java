package com.spring.task.controllers;

import com.spring.task.entities.Employee;
import com.spring.task.entities.Project;
import com.spring.task.repository.EmployeeRepository;
import com.spring.task.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository proRepo;
    @Autowired
    EmployeeRepository empRepo;

   @GetMapping("/")
   public String displayHome(Model model){
      // we are querying the database for projects
      List<Project> projects = proRepo.findAll();
       model.addAttribute("projectsList",projects);

      List<Employee> employees = empRepo.findAll();
      model.addAttribute("employeeList",employees);

      return "main/home";
    }

}

// this controller class is for displaying data on webpage. when we put some info on project webpage, then
// this data will run on the homepage website as well as in database since we are using proRepo to display data
// and it sends the data to the databse as well

// so what we did here. in other controllers we use postmapping and empPost.save to send the data to databes
// here we are dispaying a list of projects and employees through interfaces and we override a moethod there which is findall
// it helps to show all the list of projects and employees.
 // whatever we add in employee or project webpage, it displays on jome website and also in database