package com.mattpetro.springdbjpatutorial.entity;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable // this allows for us to use this class within the student entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Guardian {

    private String name;
    private String email;
    private String mobile;
}
