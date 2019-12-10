package com.example.demo;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.example.demo.dao")
@EntityScan("com.example.demo.entity")
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SpringActApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringActApplication.class, args);
    }

}
