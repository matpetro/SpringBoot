package demo;

//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Everything done in the xml can be done in the java file
// scanning for components but this time using a java file rather than xml
@Configuration
@ComponentScan(basePackages = "demo")
public class BeanConfig {
    // can also define beans from the java file instead of scanning
    /*
    @Bean
    public Doctor doctor(){
        return new Doctor();
    }*/
}
