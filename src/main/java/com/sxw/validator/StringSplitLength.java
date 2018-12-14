/*
 * 
 * @Copyright:   Copyright © 2007-2018 ky-express.com.All Rights Reserved.
 * @Date:        2018年7月18日 下午6:52:40
 * @Author:      lucius.lv
 * @Version:     1.0.0.0
 * @Description: Initialize
 */
package com.sxw.validator;

import com.kye.serviceaggregator.constant.Const;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StringSplitLengthConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface StringSplitLength {
    
    String message() default "长度不能超过"+Const.DEFAULT_MAX_LENGTH;
    String separator() default ",";
    boolean allowNullable() default true;
    int max() default Const.DEFAULT_MAX_LENGTH;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    
    
}

