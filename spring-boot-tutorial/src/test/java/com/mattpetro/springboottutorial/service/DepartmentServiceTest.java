package com.mattpetro.springboottutorial.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mattpetro.springboottutorial.entity.Department;
import com.mattpetro.springboottutorial.repository.DepartmentRepository;

@SpringBootTest // mark as a test class
// Test the Service Layer
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean  // we create a mock version of the department repository that we can use
    private DepartmentRepository departmentRepository;
    
    @BeforeEach  // called before every test
    //@BeforeAll  called only once before all the tests
    void setup(){
        // we can use this builder method because of the @Builder tag in the department file
        Department department = Department.builder().departmentName("IT").departmentAddress("Toronto").departmentCode("IT-06").departmentId(1L).build();

        // We can mock a call to the repository and return a specific department
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
    }

    @Test
    @DisplayName("Get data based on valid department name")
    //@Disable will stop the test case
    public void whenValidDepartmentName_thenDepartmentFound() {
        String departmentName = "IT";
        Department found = departmentService.getDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName()); // passes if they are equal
    }




}
