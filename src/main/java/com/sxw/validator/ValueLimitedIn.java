/*
 * @(#)ValueLimitedIn.java 1.0 2018年7月20日
 * @Copyright:  Copyright © 2007-2018 ky-express.com.All Rights Reserved.
 * @Description: 
 * 
 * @Modification History:
 * @Date:        2018年7月20日
 * @Author:      lucius.lv
 * @Version:     1.0.0.0
 * @Description: (Initialize)
 * @Reviewer:    
 * @Review Date: 
 */
package com.sxw.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValueLimitedInConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValueLimitedIn {

    String message() default "该值只能是指定数据";
    boolean nullable() default true;//是否允许空，默认允许
    String[] valuesIn() default {};
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    
}

