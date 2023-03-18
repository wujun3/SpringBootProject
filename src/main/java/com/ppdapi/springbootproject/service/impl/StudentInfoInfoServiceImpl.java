package com.ppdapi.springbootproject.service.impl;
import com.ppdapi.springbootproject.entity.Student;
import com.ppdapi.springbootproject.mapper.StudentInfoMapper;
import org.springframework.stereotype.Service;
import com.ppdapi.springbootproject.service.StudentInfoService;

import javax.annotation.Resource;
import java.util.List;


@Service
class StudentInfoInfoServiceImpl implements StudentInfoService {

    @Resource
    StudentInfoMapper studentInfoMapper;

    @Override
    public List<Student> findAll(){
        return studentInfoMapper.findAll();
    }

    @Override
    public Student findById(Integer id){
        return studentInfoMapper.findById(id);
    }

    @Override
    public void add(Student student){
        studentInfoMapper.add(student);
    }

    @Override
    public void update(Student student){
        studentInfoMapper.update(student);
    }

    @Override
    public void delete(Integer id){
        studentInfoMapper.delete(id);
    }
}

