package com.example.simplewebapp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SimpleControler {

    @RequestMapping("/")
    public String index() {
        return "Hello world..first springboot request";
    }
}
