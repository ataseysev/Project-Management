package com.spring.task.entities;

import javax.persistence.*;
import java.util.List;

// we are putting this since boot will know we put all the instances of this class to the database, with the fields
// it will create a table for us thanks to this @entity with the fields, name,id,...
//
@Entity
public class Project {

    // We are saying that this is id for each project as projectId.
    // we are creating this class to create database. it is mapping class to database. these name,
    // stage etc are actually gonna be the rows in database

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // it creates id automatically and it is p.key never repeats
    private long projectId; // to idendify  the project
    private String name;
    private String stage; // not started,completed,inprogress
    private String description;

// that means one project can have many employees to assign to it
    @OneToMany(mappedBy = "theProject")
    private List<Employee> employees; // one to many relationship

    // empty constructor
    public Project(){
    }

    public Project(String name, String stage, String description) {
        this.name = name;
        this.stage = stage;
        this.description = description;
    }

    // we need to create getter and setter for class

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
