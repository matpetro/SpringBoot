package com.mattpetro.springdbjpatutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mattpetro.springdbjpatutorial.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
    
}
