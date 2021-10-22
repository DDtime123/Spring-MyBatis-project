package com.example.springmybatis.mapper;

import com.example.springmybatis.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentMapper {

    @Insert("Insert into student(name) values(#{name})")
    public Integer save(Student student);

    @Update("Update student set name=#{name} where personId = #{personId}")
    public void updatePerson(Student student);

    @Delete("Delete from student where personId = #{personId}")
    public void deletePersonById(Integer studentId);

    @Select("SELECT student.studentId, student.name FROM student where student.studentId = #{studentId}")
    Student getPerson(Integer studentId);

    @Select("Select studentId,name from student where studentId = #{studentId}")
    @Results(value={
            @Result(property = "studentId", column = "studentId"),
            @Result(property = "name", column = "name"),
            @Result(property = "address", javaType = List.class,column = "studentId",many=@Many(select = "getAddress"))
    })
    public Student getPersonById(Integer studentId);

}




















