package com.ppdapi.springbootproject.controller;
import com.ppdapi.springbootproject.entity.ResponseEntity;
import com.ppdapi.springbootproject.entity.Student;
import com.ppdapi.springbootproject.entity.StudentInfoResponseEntity;
import com.ppdapi.springbootproject.mapper.StudentInfoMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ppdapi.springbootproject.service.StudentInfoService;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


//@Controller 控制层需要的注解
//@RestController 使用这个也是可以的，但是使用后他里面所有请求返回的都是字符串！

//一般只需要作为接口放回JSON格式数据的话推荐使用@RestController
@RestController
@Api("学生管理")
//@RequestMapping指定路径名
//@RequestMapping("/test")用这个来指定路径也是可以的
@RequestMapping(value = "/student")
public class StudentInfoController {

    @Autowired
    private StudentInfoService studentInfoService;

    @ApiOperation(value="查询所有学生列表", notes = "注意事项", httpMethod = "GET", hidden = false)
    @GetMapping("/getAll")
    public StudentInfoResponseEntity getAll(){
        return new StudentInfoResponseEntity("200","查询成功", studentInfoService.findAll());
    }

    @ApiOperation(value="学号查询学生信息", notes = "注意事项", httpMethod = "GET", hidden = false)
    @GetMapping("/findById/{id}")
    @ApiImplicitParam(name = "id",value = "学生id",dataType = "Integer")
    public StudentInfoResponseEntity findById(@PathVariable("id")  Integer id){
        List<Student> studentInfoList = new ArrayList<>();
        studentInfoList.add(studentInfoService.findById(id));
        return  new StudentInfoResponseEntity("200","查询成功",studentInfoList);
    }

    @ApiOperation(value="添加学生信息", notes = "注意事项", httpMethod = "POST", hidden = false)
    @PostMapping("/addStudent")
    @ApiImplicitParam(name = "student",value = "学生信息",dataType = "Json")

    public ResponseEntity addStudent(@RequestBody  @Valid Student student){
        studentInfoService.add(student);
        return new ResponseEntity("200", "添加成功");
    }

    @ApiOperation(value="更新学生信息", notes = "注意事项", httpMethod = "PUT", hidden = false)
    @PutMapping("/updateInfo")
    public ResponseEntity updateInfo(@RequestBody  @Valid Student student){
        studentInfoService.update(student);
        return new ResponseEntity("200", "修改成功");
    }

    @ApiOperation(value="通过学号刪除学生信息", notes = "注意事项", httpMethod = "DELETE", hidden = false)
    @DeleteMapping("/deleteInfo")
    public ResponseEntity deleteInfo(@RequestParam  Integer id){
        studentInfoService.delete(id);
        return new ResponseEntity("200", "删除成功");
    }

}
