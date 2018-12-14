/*
 * 
 * @Copyright:   Copyright © 2007-2018 ky-express.com.All Rights Reserved.
 * @Date:        2018年7月18日 下午6:52:48
 * @Author:      lucius.lv
 * @Version:     1.0.0.0
 * @Description: Initialize
 */
package com.sxw.validator;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.internal.util.logging.Log;
import org.hibernate.validator.internal.util.logging.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.invoke.MethodHandles;

public class ValueLimitedInConstraintValidator implements ConstraintValidator<ValueLimitedIn, String> {

    private static final Log LOG = LoggerFactory.make(MethodHandles.lookup());
    
    private String[] valuesIn;
    
    private boolean nullable;
    
    @Override
    public void initialize(ValueLimitedIn valueLimitedIn) {
        valuesIn = valueLimitedIn.valuesIn();
        nullable = valueLimitedIn.nullable();
        validateParameters();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext cxt) {
        if(nullable && StringUtils.isBlank(value)) {
            return true;
        }
        return ArrayUtils.contains(valuesIn, value);
    }
    
    private void validateParameters() {
        if(valuesIn == null || valuesIn.length <= 0) {
            throw LOG.getMaxCannotBeNegativeException();
        }
    }
}