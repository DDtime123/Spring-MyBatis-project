package com.example.springmybatis;

import com.example.springmybatis.config.MyBatisConfig;
import com.example.springmybatis.mapper.StudentMapper;
import com.example.springmybatis.model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class SpringmybatisApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(SpringmybatisApplication.class, args);
    }

}
