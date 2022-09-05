package com.mattpetro.springdbjpatutorial.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course") // Do not include course in the toString method as we are fetching Lazy
public class CourseMaterial {
    
    @Id
    @SequenceGenerator(
        name = "course_material_sequence",
        sequenceName = "course_material_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;

    // tag it as a one to one relationship, cascade allows for the course to be generated if it does not exist, fetch determines what is given back, LAZY excluding Course information and EAGER including it, optional determines whether you must have one to have the other (can there be material without a course)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)   
    @JoinColumn(  // define the foreign key, in this case courseId
        name = "course_id",
        referencedColumnName = "courseId"
    )
    private Course course;
}
