package com.mattpetro.springboottutorial.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController  // will be added to spring container, controller by default, will be viewed as component by default
// Specifically RestController as we are making a REST API
public class HelloController {

    // The way in which we can get a value from our properties file
    @Value("${welcome.message}")
    private String welcomeMessage;
    
    //@RequestMapping(value = "/", method = RequestMethod.GET) // So when we visit this path, we get this method called. Basically defining an endpoint
    @GetMapping("/")  // makes it even more simple, specifies its a get request so just provide the endpoint
    public String helloWorld(){
        return welcomeMessage;
    }
}
