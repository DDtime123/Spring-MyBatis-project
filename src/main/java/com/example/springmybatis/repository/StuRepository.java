package com.example.springmybatis.repository;

import com.example.springmybatis.config.MyBatisConfig;
import com.example.springmybatis.mapper.StudentMapper;
import com.example.springmybatis.model.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.*;

@Repository
public class StuRepository {

    public Integer addStu(Student stuToAdd)
    {
        Integer affectrow = 0;
        SqlSessionFactory sqlSessionFactory= MyBatisConfig.buildSqlSessionFactory();
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            Timestamp dateNow = new Timestamp(new Date().getTime());
            stuToAdd.setCreateDate(dateNow);
            stuToAdd.setUpdateDate(dateNow);
            System.out.println(stuToAdd);
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);
            affectrow = studentMapper.addStudent(stuToAdd);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
            System.out.println("rollback");
        }finally {
            if(session != null)
                session.close();
            System.out.println("affectrow : " + affectrow);
            return affectrow;
        }
    }

    public Student findStuById(Integer id){
        SqlSessionFactory sqlSessionFactory= MyBatisConfig.buildSqlSessionFactory();
        SqlSession session = null;
        Student stu = null;
        try {
            session = sqlSessionFactory.openSession();
            // create a new Student Object
            Timestamp dateNow = new Timestamp(new Date().getTime());

            // find student data by id
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);
            stu = studentMapper.getStudent(2);
            return stu;
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }finally {
            if(session != null)
                session.close();
            return stu;
        }
    }

    public Integer deleteStuById(Integer id){
        Integer affectrow = 0;
        SqlSessionFactory sqlSessionFactory= MyBatisConfig.buildSqlSessionFactory();
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);
            affectrow = studentMapper.deleteStudent(id);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
            System.out.println("rollback");
        }finally {
            if(session != null)
                session.close();
            System.out.println("affectrow : " + affectrow);
            return affectrow;
        }
    }

    public Integer updateStuById(Student stutoUpd){
        Integer affectrow = 0;
        SqlSessionFactory sqlSessionFactory= MyBatisConfig.buildSqlSessionFactory();
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            Timestamp dateNow = new Timestamp(new Date().getTime());
            stutoUpd.setCreateDate(dateNow);
            stutoUpd.setUpdateDate(dateNow);
            System.out.println(stutoUpd);
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);
            affectrow = studentMapper.updateStudent(stutoUpd);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
            System.out.println("rollback");
        }finally {
            if(session != null)
                session.close();
            System.out.println("affectrow : " + affectrow);
            return affectrow;
        }
    }

}