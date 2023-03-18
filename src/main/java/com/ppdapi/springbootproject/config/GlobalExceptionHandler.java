package com.ppdapi.springbootproject.config;



import com.ppdapi.springbootproject.entity.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintDefinitionException;
import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;

/**
 * 全局异常处理器
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * @param e 异常类
     * @return 响应
     * @Validated @Valid 前端提交的方式为json格式有效
     */
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        List<String> msgList = new ArrayList<>();
        for (ObjectError allError : allErrors) {
            msgList.add(allError.getDefaultMessage());
        }
        return new ResponseEntity("500",msgList.toString());
    }

 
    /**
     * 处理 Exception 异常
     *
     * @param httpServletRequest httpServletRequest
     * @param e                  异常
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exceptionHandler(HttpServletRequest httpServletRequest, Exception e) {
        logger.error("服务错误:", e);
        return new ResponseEntity("xxx", "服务出错");
    }
 
    /**
     * 处理 BusinessException 异常
     *
     * @param httpServletRequest httpServletRequest
     * @param e                  异常
     * @return
     */
//    @ResponseBody
//    @ExceptionHandler(value = BusinessException.class)
//    public ResponseEntity businessExceptionHandler(HttpServletRequest httpServletRequest, BusinessException e) {
//        logger.info("业务异常 code:" + e.getCode() + "msg:" + e.getMsg());
//        return new ResponseEntity(e.getCode(), e.getMsg());
//    }

    @ResponseBody
    @ExceptionHandler(value = ValidationException.class)
    public ResponseEntity ConstraintDefinitionException(HttpServletRequest httpServletRequest, ValidationException e) {
        logger.info("校验异常 code:" + "300" + "msg:" + e.getMessage());
        return new ResponseEntity("300", e.getMessage());
    }
}