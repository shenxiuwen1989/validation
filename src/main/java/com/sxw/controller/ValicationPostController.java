package com.sxw.controller;

import com.sxw.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/test")
@Validated
public class ValicationPostController {


    @RequestMapping(value = "/demo1",method = RequestMethod.POST)
    public Object demo1(@RequestBody @Valid User user, BindingResult bindingResult){
        //POST请求传入的参数：{"userName":"dd","age":120,"isFalse":true,"birthday":"21010-21-12"}
        //统一交给hibernate_validator处理
        if (bindingResult != null && bindingResult.hasErrors()) {
            return bindingErrorHandler(bindingResult);
        }
        //校验过了往下执行业务逻辑

        return "成功";
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object bindingErrorHandler(BindingResult result) {
        if (result != null) {
            //线程安全的环境使用StringBuilder
            StringBuilder errorMessage = new StringBuilder();
            for (ObjectError error : result.getAllErrors()) {
                errorMessage.append(error.getDefaultMessage()).append("\r\n");
            }
            return errorMessage.toString();
        }
        throw new RuntimeException("绑定结果为null,并不需要处理");
    }



}
