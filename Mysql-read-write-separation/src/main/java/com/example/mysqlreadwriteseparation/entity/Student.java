package com.example.mysqlreadwriteseparation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    /**
    * 主键id
    */
    private Integer id;

    private String studentNumber;

    private String name;

    /**
    * 学生年龄
    */
    private String studentAge;
}