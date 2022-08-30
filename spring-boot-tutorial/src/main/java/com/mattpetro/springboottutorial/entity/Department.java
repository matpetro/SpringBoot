package com.mattpetro.springboottutorial.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity  //This can now interact with the database (it is an entity)
@Data // this auto creates setters and getters
@NoArgsConstructor // default constructor
@AllArgsConstructor // constructor with all args
@Builder 
/* If you just want getters and setters juust do this:
 * @Getter
 * @Setter
*/
public class Department {

    // Make the deparment Id the primary key, do as below (Auto Generates the ID aswell)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    @NotBlank(message = "Please Add Department Name") // validation that ensures we get a name
    /*
    Many types of validations available

    @Length(max = 50, min = 1)
    @Email
    @Positive
    @Negative
    @PositiveOrZero
    @Future
    @FutureOrPresent
    */
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;


    // Remove as we can create them using a tool called Lombok
    /*
    public Department(){

    }

    public Department(Long departmentId, String departmentName, String departmentAddress, String departmentCode){
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentAddress = departmentAddress;
        this.departmentCode = departmentCode;
    }
    

    
    public Long getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentAddress() {
        return this.departmentAddress;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    public String getDepartmentCode() {
        return this.departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }
    

    @Override
    public String toString() {
        return "Department{"+
                "deparmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", departmentAddress='" + departmentAddress + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                "}";
    }
    */
}
