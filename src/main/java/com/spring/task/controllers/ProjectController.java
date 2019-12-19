package com.spring.task.controllers;


import com.spring.task.entities.Employee;
import com.spring.task.repository.EmployeeRepository;
import com.spring.task.repository.ProjectRepository;
import com.spring.task.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/projects") //
    public class ProjectController {

    @Autowired // we dont need to create instance, if we put this. spring does it instead with this anno.
    ProjectRepository proRep;

    @Autowired
    EmployeeRepository empRepo;


    @GetMapping
    public String displayProjects(Model model){
        List<Project> projects = proRep.findAll();
        model.addAttribute("projects",projects);
        return "projects/list-projects";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model){
        // model : it exchanges the data between view and controller
        // if we want to bind the data btw html and java then we use Model
        Project aProject = new Project();
        // we are mapping empty objects to the form. we wont create object in java,
        // we will in html form. this object called "project" in html form. {project} coming form here in html, they
        // should be the same
        List<Employee> employees = empRepo.findAll();
        model.addAttribute("project",aProject);
        // we need to call this method and specifiyig it "project" the actual project is aproject, it is empty insttance
        //we create above. aProject is empty project instance
        model.addAttribute("allEmployees",employees);

        return "projects/new-project";
    }

    @PostMapping(value = "/save")
    public String createProject(Project project, @RequestParam List<Long>employees, Model model) {
        // this should handle saving to the database.. we will save project instance to the database with this  proRep.save(project);
        proRep.save(project);
        // basically projects/save does this. taking the project we submitted in the form and saves it to the db using this repo

        Iterable<Employee>chosenEmployee = empRepo.findAllById(employees);
        // use a redirect to prevent duplicate submissions. when we save smth to the ds then we redirect
        // this is how we redirect check the inside ""
        return "redirect:/projects/new";
    }

}
// after creating createProject at the begining, then we are able to click to the submit button and in our
// online databse there is new project now. but the table name(empty) is created when we put @Entitiy above class