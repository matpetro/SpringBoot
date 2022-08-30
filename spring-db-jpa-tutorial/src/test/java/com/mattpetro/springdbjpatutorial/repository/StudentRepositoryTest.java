package com.mattpetro.springdbjpatutorial.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mattpetro.springdbjpatutorial.entity.Student;

@SpringBootTest
class StudentRepositoryTest {
    
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        //Student student = Student.builder().emailId("d@gmail.com").firstName("dfs").lastName("rewr").guardianEmail("dfs@re.com").guardianMobile("90943242").guardianName("dsaui").build();

        //studentRepository.save(student);
    }

    @Test
    public void printAllStudents(){
        List<Student> students = studentRepository.findAll();
        System.out.println(students);
    }
}
