package com.example.springmybatis;

import com.example.springmybatis.config.MyBatisConfig;
import com.example.springmybatis.mapper.StudentMapper;
import com.example.springmybatis.model.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.Date;

@SpringBootTest
class SpringmybatisApplicationTests {

    @Test
    void findStuByIdtest() {
        SqlSessionFactory sqlSessionFactory= MyBatisConfig.buildSqlSessionFactory();
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            // create a new Student Object
            Timestamp dateNow = new Timestamp(new Date().getTime());

            Student student = new Student(10,"michael","1@sina.com",dateNow,dateNow);

            // find student data by id
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);
            Student stu = studentMapper.getStudent(2);
            System.out.println(stu.toString());
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }finally {
            if(session != null)
                session.close();
        }
    }



}
