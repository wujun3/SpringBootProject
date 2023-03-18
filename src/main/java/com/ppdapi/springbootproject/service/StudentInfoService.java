package com.ppdapi.springbootproject.service;
import com.ppdapi.springbootproject.entity.Student;
import java.util.List;

public interface StudentInfoService {

    //查询所有学生信息
    List<Student> findAll();

    //通过学号id 查询学生信息     id 学号
    Student findById(Integer id);

    //添加学生信息  student  学生对象
    void add(Student student);

    //更新学生信息  student  学生对象
    void update(Student student);

    //删除学生信息     id  学号
    void delete(Integer id);

}
