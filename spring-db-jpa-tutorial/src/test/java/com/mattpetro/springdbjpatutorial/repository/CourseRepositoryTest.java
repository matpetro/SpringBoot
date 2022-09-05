package com.mattpetro.springdbjpatutorial.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.mattpetro.springdbjpatutorial.entity.Course;
import com.mattpetro.springdbjpatutorial.entity.Teacher;

@SpringBootTest
public class CourseRepositoryTest {
    
    @Autowired
    private CourseRepository repository;

    @Test
    public void printCourses(){
        List<Course> courses = repository.findAll();
        System.out.println(courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher t = Teacher.builder().firstName("Ysd").lastName("fdsf").build();
        Course course = Course.builder().title("Python").credit(6).teacher(t).build();

        repository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPageWith3Records = PageRequest.of(0, 3);
        Pageable secondpwith2records = PageRequest.of(1,2);

        List<Course> courses = repository.findAll(firstPageWith3Records).getContent();

        long totalElements = repository.findAll(firstPageWith3Records).getTotalElements();

        int totalPages = repository.findAll(firstPageWith3Records).getTotalPages();
        System.out.println(courses);
    }

    @Test
    public void findAllSorted(){
        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));

        System.out.println(sortByTitle);
    }
}
