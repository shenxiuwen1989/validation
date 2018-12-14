/*
 * @Copyright:   Copyright © 2007-2018 ky-express.com.All Rights Reserved.
 * @Date:        2018年7月18日 下午6:52:40
 * @Author:      lucius.lv
 * @Version:     1.0.0.0
 * @Description: Initialize
 */
package com.sxw.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StringToIntegerConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface StringToInteger {
    
    String message() default "必须是数字";
    String separator() default ",";
    int max() default Integer.MAX_VALUE;
    int min() default Integer.MIN_VALUE;
    boolean allowNullable() default false;//是否允许为空
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    
}

