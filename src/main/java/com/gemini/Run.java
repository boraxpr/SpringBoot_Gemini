package com.gemini;


import com.gemini.repository.EmployeeRepository;
import jparsec.ephem.Target;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.thymeleaf.util.StringUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Run {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(Target.getNames()));
        SpringApplication.run(Run.class, args);
    }
}