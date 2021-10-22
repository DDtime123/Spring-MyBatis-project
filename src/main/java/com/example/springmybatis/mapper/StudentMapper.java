package com.example.springmybatis.mapper;

import com.example.springmybatis.model.Student;
import org.apache.ibatis.annotations.*;

public interface StudentMapper {

    @Select(value="select id,name,email,createDate,updateDate from stuinfo where id=#{id}")
    public Student getStudent(Integer id);

    @Insert("insert into stuinfo(id,name,email,createDate,updateDate) "
            + "VALUES(#{id},#{name},#{email},#{createDate},#{updateDate})")
    public Integer addStudent(Student student);

    @Update("update stuinfo set name=#{name} where id = #{id}")
    public Integer updateStudent(Student student);

    @Delete(value="Delete from stuinfo where id = #{id}")
    public Integer deleteStudent(Integer id);
//
//
//
//    @Select("Select id,name,email,createDate，updateDate from stuinfo where id = #{id}")
//    @Results(value={
//            @Result(property = "id", column = "id"),
//            @Result(property = "name", column = "name"),
//            @Result(property = "email", column = "email"),
//            @Result(property = "createDate", column = "createDate"),
//            @Result(property = "updateDate", column = "updateDate")
//    })
//    public Student getStudentById(Integer id);
//
//    public void addStudent(@Param("student") Student student);
}




















