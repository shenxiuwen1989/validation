/*
 * 
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
@Constraint(validatedBy = StringSplitLengthConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface StringSplitLength {
    /**
     * 默认最大长度
     */
    public static final int DEFAULT_MAX_LENGTH = 20;
    
    String message() default "长度不能超过"+DEFAULT_MAX_LENGTH;
    String separator() default ",";
    boolean allowNullable() default true;
    int max() default DEFAULT_MAX_LENGTH;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    
    
}

