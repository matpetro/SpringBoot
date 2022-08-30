package com.mattpetro.springboottutorial.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.mattpetro.springboottutorial.entity.Department;

@DataJpaTest // use to test repositories
public class DepartmentRepositoryTest {
    
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp(){
        Department department = Department.builder().departmentName("Mech Eng").departmentAddress("Toronto").departmentCode("suii").build();

        entityManager.persist(department); // will make the entry persist without effecting the database
    }

    @Test
    public void findById_thenReturnDepartment() {
        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(), "Mech Eng");
    }
}
