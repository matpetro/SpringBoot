package com.mattpetro.springdbjpatutorial.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable // this allows for us to use this class within the student entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// remaning of the columns within the db below
@AttributeOverrides({
    @AttributeOverride(
        name = "name",
        column = @Column(name = "guardian_name")
    ),
    @AttributeOverride(
        name = "email",
        column = @Column(name = "guardian_email")
    ),
    @AttributeOverride(
        name = "mobile",
        column = @Column(name = "guardian_mobile")
    )
})
public class Guardian {

    private String name;
    private String email;
    private String mobile;
}
