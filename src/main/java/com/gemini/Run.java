package com.gemini;


import com.gemini.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Run {

    public static void main(String[] args) {
        SpringApplication.run(Run.class, args);
    }
}