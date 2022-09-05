package com.mattpetro.springdbjpatutorial.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mattpetro.springdbjpatutorial.entity.Guardian;
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
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder().name("g").email("fds@yahoo.com").mobile("905435345").build();
        Student student = Student.builder().firstName("He").emailId("diuygiugi@gmail.com").lastName("fds").guardian(guardian).build();

        studentRepository.save(student);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("dfs");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("d");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByGN(){
        List<Student> students = studentRepository.findByGuardianName("g");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByEmail(){
        String student = studentRepository.getStudentFirstNameByEmailAddress("d@gmail.com");

        System.out.println("student = " + student);
    }

    @Test
    public void printStudentByEmailNative(){
        Student student = studentRepository.getStudentByEmailAdd("d@gmail.com");

        System.out.println("student = " + student);
    }

    @Test
    public void updateStudentName(){
        studentRepository.updateStudentNameByEmailId("NewName", "d@gmail.com");
    }


    @Test
    public void printAllStudents(){
        List<Student> students = studentRepository.findAll();
        System.out.println(students);
    }
}
