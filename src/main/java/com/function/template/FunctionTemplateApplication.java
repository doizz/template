package com.function.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;

@SpringBootApplication(exclude={MultipartAutoConfiguration.class})
public class FunctionTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(FunctionTemplateApplication.class, args);
    }

}