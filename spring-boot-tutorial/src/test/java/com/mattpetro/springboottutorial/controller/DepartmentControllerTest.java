package com.mattpetro.springboottutorial.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.mattpetro.springboottutorial.entity.Department;
import com.mattpetro.springboottutorial.error.DepartmentNotFoundException;
import com.mattpetro.springboottutorial.service.DepartmentService;


@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp(){
        department = Department.builder().departmentAddress("Toronto").departmentCode("IT06").departmentName("IT").departmentId(1L).build();
    }

    @Test
    void saveDepartment() throws Exception{
        Department inputDepartment = Department.builder().departmentAddress("Toronto").departmentCode("IT06").departmentName("IT").build();

        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);  // when save department id called with that input, return our made up department

        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\n" +
                "\t\"departmentName\":\"IT\",\n" +
                "\t\"departmentAddress\":\"Toronto\",\n" +
                "\t\"departmentCode\":\"IT06\"\n" +
                "}"))
                .andExpect(MockMvcResultMatchers.status().isOk()); // this is the mock API request
    }

    @Test
    void getDepartmentById() throws Exception{
        Mockito.when(departmentService.getDepartment(1L)).thenReturn(department);

        // get the department and the anmes should match
        mockMvc.perform(MockMvcRequestBuilders.get("/departments/1")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName").value(department.getDepartmentName()));
    }
}
