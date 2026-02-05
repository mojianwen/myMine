package com.mining.safety;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mining.safety.mapper")
public class MiningSafetyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiningSafetyApplication.class, args);
    }
}