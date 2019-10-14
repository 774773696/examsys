package com.qfedu.examsys.exception;

import com.qfedu.examsys.common.JsonBean;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*//异常类必须使用该注解
@ControllerAdvice
@ResponseBody//看情况*/
/*@RestControllerAdvice 相当于 @ControllerAdvice + @ResponseBody*/
@RestControllerAdvice
public class GlobalException {


    @ExceptionHandler(AuthorizationException.class)
    //@ResponseBody
    public String nopermException(AuthorizationException ex){

        //跳转到指定的资源
        return "noperms";
    }

}
