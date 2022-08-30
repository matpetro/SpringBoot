package com.mattpetro.springboottutorial.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mattpetro.springboottutorial.entity.Department;
import com.mattpetro.springboottutorial.error.DepartmentNotFoundException;
import com.mattpetro.springboottutorial.service.DepartmentService;

@RestController
public class DepartmentController {

    @Autowired
    // Autowired basically just gets the object from your spring container and creates it
    private DepartmentService departmentService;

    // Creating a logger for this class
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    
    @PostMapping("/departments")
    // RequestBody allows us to convert the incoming json to the object we want
    // check if the request body is valid with comparison to what we said
    public Department saveDepartment(@Valid @RequestBody Department department){
        // send to department service for processing
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/getDepartments")
    // get request for all of our departments in the database
    public List<Department> getDeparments(){
        LOGGER.info("Inside getDepartments of DepartmentController");
        return departmentService.getDepartments();
    }

    @GetMapping("/departments/{id}")
    // get request for a particular department
    // use path variable
    public Department getDeparmentById(@PathVariable("id") Long id) throws DepartmentNotFoundException{
        LOGGER.info("Inside getDepartmentById of DepartmentController");
        return departmentService.getDepartment(id);
    }

    @DeleteMapping("/deleteDepartment/{id}")
    // delete a department
    public String deleteDepartmentById(@PathVariable("id") Long id){
        LOGGER.info("Inside deleteDepartmentById of DepartmentController");
        departmentService.deleteDepartment(id);
        return "Department Deleted Successfully";
    }

    @PutMapping("/updateDepartment/{id}")
    // get the id from the path and get the update from the object
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
        LOGGER.info("Inside updateDepartment of DepartmentController");
        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String name){
        LOGGER.info("Inside getDepartmentByName of DepartmentController");
        return departmentService.getDepartmentByName(name);
    }
}
