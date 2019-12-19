package com.spring.task.repository;

// it is a mechanisim to access to the database
//we do stuff here for database

import com.spring.task.entities.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project,Long> {
    //  we will be able to insert/delete data into the database with this class, it is all it does
    // we need to put class we are working on it as param. and long is idendify field which is  long ID
    @Override
    public List<Project> findAll();

}
