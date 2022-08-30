package com.mattpetro.springdbjpatutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mattpetro.springdbjpatutorial.entity.Student;

@Repository  // mark it as a REPO

// extending JPARepository gives us default methods that we would want to use
public interface StudentRepository extends JpaRepository<Student, Long>{
}
