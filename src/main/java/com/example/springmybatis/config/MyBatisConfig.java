package com.example.springmybatis.config;

import com.example.springmybatis.mapper.StudentMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;

// 1. 从 Java 或 XML 创建 SQLSessionFactory
public class MyBatisConfig {
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost/studb" +
            "?useUnicode=true&useJDBCCompliantTimezoneShift" +
            "=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String USERNAME = "studbuser";
    public static final String PASSWORD = "123test123";
    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSessionFactory buildSqlSessionFactory() {
        DataSource dataSource = new PooledDataSource(DRIVER,URL,USERNAME,PASSWORD);

        Environment environment = new Environment("Development", new JdbcTransactionFactory(),dataSource);

        Configuration configuration = new Configuration(environment);

        configuration.addMapper(StudentMapper.class);

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory = builder.build(configuration);

        return sqlSessionFactory;
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }

    // 动态 SQL 测试
    public String getStudentByName(String name){
        return new SQL(){
            {
                SELECT("*");
                FROM("stuinfo");
                WHERE("name like #{name} || '%'");
            }
        }.toString();
    }
}



