package com.example.simplewebapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Array;
import java.util.Arrays;

@SpringBootApplication
public class SimpleWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleWebAppApplication.class, args);
    }
@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx)
    { return args -> {

        System.out.println("let's inspect he beans privide b spring boot");
        String[] beansNames= ctx.getBeanDefinitionNames();
        Arrays.sort(beansNames);
        for (String beansname :beansNames )
        {
            System.out.println( beansname);
        }

    };

    }
}
