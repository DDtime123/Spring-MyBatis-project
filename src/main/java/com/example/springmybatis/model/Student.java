package com.example.springmybatis.model;

import java.util.Date;
import java.sql.Timestamp;

public class Student {
    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }

    private Integer id;
    private String name;
    private String email;
    private Date createDate;
    private Date updateDate;

    public Student(Integer id,String name,String email) {
        this.name = name;
        this.email = email;
        this.id = id;
    }

    public Student(Integer id, String name, String email, Timestamp createDate, Timestamp updateDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
