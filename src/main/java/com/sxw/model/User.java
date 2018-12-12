package com.sxw.model;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.Pattern;

@Data
@ToString
public class User {

    @NotBlank(message="用户名不能为空")
    private String userName;

    @NotBlank(message="年龄不能为空")
    @Pattern(regexp="^[0-9]{1,2}$",message="年龄不正确")
    private String age;

    @AssertFalse(message = "isFalse 必须为false")
    private Boolean isFalse;

    /**
     * 如果是空，则不校验，如果不为空，则校验
     */
    @Pattern(regexp="^[0-9]{4}-[0-9]{2}-[0-9]{2}$",message="出生日期格式不正确")
    private String birthday;


}
