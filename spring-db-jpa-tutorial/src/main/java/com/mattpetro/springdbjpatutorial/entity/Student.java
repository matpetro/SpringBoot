package com.mattpetro.springdbjpatutorial.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // entity of a database

// Auto generate getters and setter contructors etc. for this entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Table(
    name="tbl_student",
    uniqueConstraints = @UniqueConstraint( // ensure email id is a unique value
        name = "emailid_unique",
        columnNames = "email_address"
    )
    )  // specify the name
public class Student {

    @Id  // primary key
    @SequenceGenerator( // How to develop a sequence
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )
    @GeneratedValue(  // generate a random value for the ID following our written sequence
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"
    )
    private Long studentId;

    private String firstName;
    private String lastName;

    @Column(
        name="email_address",
        nullable = false  // should not be null
    ) //specify name of column
    private String emailId;

    @Embedded
    private Guardian guardian;
}
