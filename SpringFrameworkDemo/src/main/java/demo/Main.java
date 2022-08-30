package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        // When we use the xml for our context:
        //ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        // When we use the java file for our context:
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        Doctor doctor = context.getBean(Doctor.class);  //made a bean relating to this class, which allows us to contruct an occurance of it
        doctor.assist();
        doctor.setQualification("MBBS");
        System.out.println(doctor.getQualification());

        Doctor doctor1 = context.getBean(Doctor.class);
        System.out.println(doctor1.getQualification());

        // As we can see, doctor1 has its qualifications as MBBS even though we never set it, as the Doctor is a singleton object

        // When doctor scope is set to prototype, they are different

        /*
        Nurse nurse = context.getBean(Nurse.class);  //made a bean relating to this class, which allows us to contruct an occurance of it
        nurse.assist();

        //can also get the data as a object through the id
        Nurse nurse2 = (Nurse) context.getBean("nurse");
        nurse2.assist();


        Staff staff = context.getBean(Doctor.class);
        staff.assist();

        // As you can see, we are getting all the objects from the spring container itself
        */
    }
}
