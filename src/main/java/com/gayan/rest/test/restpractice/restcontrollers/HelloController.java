package com.gayan.rest.test.restpractice.restcontrollers;

import com.gayan.rest.test.restpractice.miscobjects.HelloBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class HelloController {

    @GetMapping(path="/hello")
    public String getHelloMsg(){
        return "Hello World";
    }

    @GetMapping(path ="/hello/hellobean")
    public HelloBean getHelloBean(){
        List<String> children = Arrays.asList("JAck", "John", "Jacobs");
        return new HelloBean("Hello Bean!!1", 45, children);
    }
}
