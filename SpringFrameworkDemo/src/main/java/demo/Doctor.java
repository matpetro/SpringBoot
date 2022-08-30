package demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//mark this as a component and create the beans out of it
@Scope(scopeName = "prototype") // set the scope, singleton meaning only one, prototype meaning new object every time
@Component
public class Doctor implements Staff, BeanNameAware {

    private String qualification;
    //private Nurse nurse;

    /* public Nurse getNurse() {
        return this.nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }; */

    /*
    public Doctor(String qual){
        this.qualification = qual;
    }*/

    public void setQualification(String qual){
        this.qualification = qual;
    }

    public String getQualification(){
        return this.qualification;
    }

    public void assist(){
        System.out.println("Docter is assisting");
    }

    @Override
    public void setBeanName(String name){
        // get executed when bean is called
        System.out.println("Set bean name method is called");
    }

    @PostConstruct
    public void postConstruct(){
        //gets executed after the bean is constructed
        System.out.println("post construct called");
    }
    
}
