package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student first = new Student();
            first.setEmail("eivydas@gmail.com");
            first.setAge(19);
            first.setName("Eivydas");

            repository.save(first);
        };
    }

}
