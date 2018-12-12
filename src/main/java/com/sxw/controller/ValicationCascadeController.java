package com.sxw.controller; /*
 * @(#)ValicationCascadeController.java 1.0 2018/12/12
 * @Copyright:  Copyright © 2007-2018 ky-express.com.All Rights Reserved.
 * @Description: 
 * 
 * @Modification History:
 * @Date:        2018/12/12
 * @Author:      
 * @Version:     1.0.0.0
 * @Description: (Initialize)
 * @Reviewer:    
 * @Review Date: 
 */

import com.sxw.model.CascadeValication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ValicationCascadeController {

    @RequestMapping(value = "/demo2",method = RequestMethod.POST)
    public Object demo1(@Valid @RequestBody CascadeValication param){
        //POST请求传入的参数：{"userName":"dd","age":120,"isFalse":true,"birthday":"21010-21-12"}

        //校验过了往下执行业务逻辑

        return "成功";
    }
}
