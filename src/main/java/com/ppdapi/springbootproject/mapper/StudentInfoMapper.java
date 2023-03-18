package com.ppdapi.springbootproject.mapper;

import com.ppdapi.springbootproject.entity.Student;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentInfoMapper {

    @Select("select * from student")
    List<Student> findAll();

    @Select("select * from student where id =#{id} ")
    Student findById(Integer id);

    @Update("INSERT INTO student (NAME,age,sex ) VALUES (#{name},#{age},#{sex});")
    @Transactional
    void add(Student student);

    @Update("UPDATE student SET name=#{name},age=#{age},sex=#{sex} WHERE id =#{id};")
    @Transactional
    void update(Student student);

    @Update("delete from student where id=#{id};")
    @Transactional
    void delete(Integer id);

}
