package com.mattpetro.springboottutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mattpetro.springboottutorial.entity.Department;

@Repository
//must extend off JPA (will give us all the methods we need), provide it the entity and type of primary key
// After this we should be fine
// This file links our entities to the actual database
public interface DepartmentRepository extends JpaRepository<Department, Long>{

    // must be named in camel case, will allow us to find by name now
    public Department findByDepartmentName(String departmentName);
    // this variant will treat all strings as lowercase
    public Department findByDepartmentNameIgnoreCase(String departmentName);

    /*Can also annotate with a specific query
    @Query("SELECT ... FROM ... WHERE ...", nativeQuery = true)
    public Department findBySpecificQuery();
    */
    
    // The naming conventions can be found here: https://docs.spring.io/spring-data/data-jpa/docs/1.4.x/reference/htmlsingle/???#jpa.query-methods.query-creation

}
