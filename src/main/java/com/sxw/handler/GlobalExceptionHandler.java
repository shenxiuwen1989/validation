package com.sxw.handler;

import com.sxw.exception.ApplicationException;
import com.sxw.json.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

//@ControllerAdvice// 作为一个控制层的切面处理
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class) // 所有的异常都是Exception子类
    public Object defaultErrorHandler(HttpServletRequest request, Exception e) {

        JsonResult jsonResult = new JsonResult();
        if(e instanceof ApplicationException){
            logger.error("异常：",e);
            ApplicationException ex  = (ApplicationException)e;
            jsonResult.setError_code(ex.getError_code()==null?"99":ex.getError_code()); // 标记一个错误信息类型
            jsonResult.setError_msg(ex.getError_msg());
        }else if(e instanceof ConstraintViolationException){
            logger.error("异常：",e);
            ConstraintViolationException exs = (ConstraintViolationException) e;
            Set<ConstraintViolation<?>> violations = exs.getConstraintViolations();
            StringBuffer buffer = new StringBuffer();
            for (ConstraintViolation<?> item : violations) {
                buffer.append(","+item.getMessage());
                System.out.println(item.getMessage());
            }
            jsonResult.setError_code("88"); // 标记一个错误信息类型
            jsonResult.setError_msg(buffer.toString().substring(1));
        }else if(e instanceof  MethodArgumentNotValidException){//校验Valid抛出的异常
            String msg = "参数校验不通过。";
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException)e;
            BindingResult bindingResult = exception.getBindingResult();
            if(bindingResult!= null && bindingResult.hasErrors()) {
                msg = bindingResult.getAllErrors().get(0).getDefaultMessage();

            }
            jsonResult.setError_code("100");
            jsonResult.setError_msg(msg);
        }
        logger.error("===============异常===============：",e);
        return jsonResult;
    }
}
