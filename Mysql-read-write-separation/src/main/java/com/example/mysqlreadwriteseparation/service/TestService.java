package com.example.mysqlreadwriteseparation.service;

import com.example.mysqlreadwriteseparation.config.ReadOnly;
import com.example.mysqlreadwriteseparation.entity.Student;
import com.example.mysqlreadwriteseparation.entity.StudentExample;
import com.example.mysqlreadwriteseparation.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description:
 * @Author: PanYi
 * @Date: 2022/7/27
 */
@Service
public class TestService {


    private final StudentMapper studentMapper;
    @Autowired
    public TestService(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @ReadOnly
    public List<Student> getAll() {
        StudentExample example = new StudentExample();
        return studentMapper.selectByExample(example);
    }

    /**
     * 测试读写和插入，应该用到主库
     */
    public void testInsert() {
        studentMapper.selectByExample(new StudentExample());
        Student student = new Student();
        student.setName("test");
        student.setStudentAge("18");
        studentMapper.insertSelective(student);
    }

    /**
     * 测试插入，应该用到主库
     */
    public void testInsert2() {
        Student student = new Student();
        student.setName("效力飞刀");
        student.setStudentAge("32");
        studentMapper.insertSelective(student);
    }

    /**
     * 测试事务是否正常运行
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public void testTransaction() {
        Student student = new Student();
        student.setName("test");
        student.setStudentAge("18");
        studentMapper.insertSelective(student);
        throw new RuntimeException("测试事务");
    }

}
