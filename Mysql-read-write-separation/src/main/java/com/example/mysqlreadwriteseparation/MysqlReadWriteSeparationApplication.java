package com.example.mysqlreadwriteseparation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement(order = 10)
public class MysqlReadWriteSeparationApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysqlReadWriteSeparationApplication.class, args);
    }

}
