package com.mattpetro.springdbjpatutorial.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mattpetro.springdbjpatutorial.entity.Student;



@Repository  // mark it as a REPO

// extending JPARepository gives us default methods that we would want to use
public interface StudentRepository extends JpaRepository<Student, Long>{

    // Creating custom methods or querys within our repo

    // This method will find students by first name
    public List<Student> findByFirstName(String firstName);

    // This method will find students with the name containing specific characters
    public List<Student> findByFirstNameContaining(String name);

    // gets last names that are not null
    public List<Student> findByLastNameNotNull();

    // Get the student by their guardian name
    public List<Student> findByGuardianName(String guardName);

    public List<Student> findByFirstNameAndLastName(String fn, String ln);

    // This is a custom query we a re building, not following the naming convention
    // defined based on class names and attributes
    // This is a JPQL query
    @Query("select s.firstName from Student s where s.emailId = ?1")  // ?1 represents the first parameter
    public String getStudentFirstNameByEmailAddress(String emailId);

    // This query is defined natively, using the query language supported by our database
    @Query(value = "SELECT * FROM tbl_student s WHERE s.email_address = ?1", nativeQuery = true)
    public Student getStudentByEmailAdd(String emailId);

    // This query uses the Param tag so that it is nicer to read
    @Query(value = "SELECT * FROM tbl_student s WHERE s.email_address = :emailId", nativeQuery = true)
    public Student getStudentByEmailAddNamedParam(@Param("emailId") String emailId);

    @Modifying  // must add this tag as we are updating data
    @Transactional // also must be added
    // updating the first name by the email ID
    @Query(value = "update tbl_student set first_name = ?1 where email_address = ?2", nativeQuery = true)
    int updateStudentNameByEmailId(String firstName, String emailId);

    


    // The naming conventions can be found here: https://docs.spring.io/spring-data/data-jpa/docs/1.4.x/reference/htmlsingle/???#jpa.query-methods.query-creation
}
