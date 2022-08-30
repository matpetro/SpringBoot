package demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration // this is our configuration file
@ComponentScan(basePackages = "demo") // scan for components within the directory
@EnableAspectJAutoProxy // enables your aspects
public class BeanConfig {
    
}
