package com.mattpetro.springdbjpatutorial.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mattpetro.springdbjpatutorial.entity.Course;
import com.mattpetro.springdbjpatutorial.entity.CourseMaterial;

@SpringBootTest
public class CourseMaterialRepositoryTest {
    
    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void SaveCourseMaterial(){
        Course course = Course.builder().title("DSA").credit(6).build();
        CourseMaterial cm = CourseMaterial.builder().url("dsdas.com").course(course).build();

        repository.save(cm);
    }

    @Test
    public void printAllCM(){
        List<CourseMaterial> cm = repository.findAll();

        System.out.println(cm);
    }
}