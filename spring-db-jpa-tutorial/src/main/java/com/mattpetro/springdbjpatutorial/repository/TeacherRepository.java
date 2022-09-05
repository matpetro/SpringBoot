package com.mattpetro.springdbjpatutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mattpetro.springdbjpatutorial.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>{
    
}
