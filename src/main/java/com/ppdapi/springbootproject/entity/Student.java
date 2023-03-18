package com.ppdapi.springbootproject.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@ApiModel(description ="学生类")
public class Student {
    @ApiModelProperty(name="id",dataType="Integer",value="学号")
    private Integer id;

    @ApiModelProperty(name="name",dataType="String",value="姓名")
    @NotBlank(message = "name不能为空")
    private String name;

    @ApiModelProperty(name="age",dataType="String",value="年龄")
    @NotBlank(message = "age不能为空")
    private String age;

    @ApiModelProperty(name="sex",dataType="String",value="性别")
    @NotBlank(message = "sex不能为空")
    private String sex;
}
