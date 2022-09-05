package com.mattpetro.springdbjpatutorial.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mattpetro.springdbjpatutorial.entity.Course;
import com.mattpetro.springdbjpatutorial.entity.Teacher;

@SpringBootTest
public class TeacherRepositoryTest {
    
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        //Course course = Course.builder().title("DBA").credit(5).build();
        //Teacher teacher = Teacher.builder().firstName("Yes").lastName("Sir").courses(List.of(course)).build();

        //teacherRepository.save(teacher);
    }
}
