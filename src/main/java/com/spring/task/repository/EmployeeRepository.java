package com.spring.task.repository;

import com.spring.task.entities.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {

    @Override
    public List<Employee> findAll();


}
