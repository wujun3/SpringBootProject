package com.ppdapi.springbootproject.entity;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@ApiModel(description ="学生信息返回类")
public class StudentInfoResponseEntity {

    private String code;

    private String message;

    private List<Student> Data;
}
