package com.hello.tms.mock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hello.tms.mock.dao")
public class TmsTestMockApplication {

    public static void main(String[] args) {
        SpringApplication.run(TmsTestMockApplication.class, args);
    }

}
