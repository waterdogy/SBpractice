package com.chenyulong.config;

import com.chenyulong.util.CodeMsg;
import com.chenyulong.util.ResultMsg;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice(basePackages = "com.chenyulong")
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResultMsg<String> exceptionHandler(Exception e) {
        System.out.println("error has happened!");
        if(e instanceof DuplicateKeyException) {
            System.out.println("duplication error has been detected!");
        }
        return ResultMsg.error(CodeMsg.SERVER_ERROR);
    }
}
