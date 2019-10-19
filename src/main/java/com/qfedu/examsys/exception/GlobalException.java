package com.qfedu.examsys.exception;

import com.qfedu.examsys.common.JsonBean;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*//异常类必须使用该注解
@ControllerAdvice
@ResponseBody//看情况*/
/*@RestControllerAdvice 相当于 @ControllerAdvice + @ResponseBody*/
@ControllerAdvice
public class GlobalException {


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JsonBean exception(Exception e){

        return new JsonBean(1,e.getMessage());
    }

}
