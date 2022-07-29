package com.example.mysqlreadwriteseparation.controller;

import com.example.mysqlreadwriteseparation.entity.Student;
import com.example.mysqlreadwriteseparation.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: PanYi
 * @Date: 2022/7/27
 */

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {


    private final TestService testService;
    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping("/getAll")
    public Map<String, Object> getAll() {
        List<Student> all = testService.getAll();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "success");
        map.put("data", all);
        return map;
    }

    @PostMapping("/testInsert")
    public Map<String, Object> testInsert() {
        testService.testInsert();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "success");
        return map;
    }

    @PostMapping("/testInsert2")
    public Map<String, Object> testInsert2() {
        testService.testInsert2();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "success");
        return map;
    }

    @PostMapping("/testTransaction")
    public Map<String, Object> testTransaction() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        try {
            testService.testTransaction();
            map.put("msg", "success");
        } catch (Exception e) {
            map.put("msg", "success, but transaction rollback");
            log.error("testTransaction error{},{}", e.getMessage(),e);
            return map;
        }
        return map;
    }


}
