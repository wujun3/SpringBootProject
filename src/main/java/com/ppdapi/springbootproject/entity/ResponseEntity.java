package com.ppdapi.springbootproject.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseEntity {

    private String code;

    private String message;

}
