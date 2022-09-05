package com.mattpetro.springdbjpatutorial.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {
    
    @Id
    @SequenceGenerator(
        name = "teacher_sequence",
        sequenceName = "teacher_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "teacher_sequence"
    )
    private Long teacherId;
    private String firstName;
    private String lastName;

    /* // defining a one to many relationship between teacher and course
    @OneToMany(cascade = CascadeType.ALL)
    // creates the foreign key within the courses
    @JoinColumn(
        name = "teacher_id",
        referencedColumnName = "teacherId"
    )
    private List<Course> courses; 
    
    Try to use Many To One rather than One to Many*/
}
