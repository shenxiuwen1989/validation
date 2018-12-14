/*
 * @Copyright:   Copyright © 2007-2018 ky-express.com.All Rights Reserved.
 * @Date:        2018年7月18日 下午6:52:48
 * @Author:      lucius.lv
 * @Version:     1.0.0.0
 * @Description: Initialize
 */
package com.sxw.validator;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StringToIntegerConstraintValidator implements ConstraintValidator<StringToInteger, String> {

    private int min;
    private int max;
    private boolean allowNullable;
    
    @Override
    public void initialize(StringToInteger stringToInteger) {
        this.max = stringToInteger.max();
        this.min = stringToInteger.min();
        this.allowNullable = stringToInteger.allowNullable();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext cxt) {
        
        //如果允许为空，并且值也是空，则验证直接通过
        if(allowNullable && StringUtils.isEmpty(value)) {
            return true;
        }
        
        //如果字符串为空校验不通过
        if(StringUtils.isEmpty(value) || !NumberUtils.isCreatable(value)) {
            return false;
        }
        
        double doubleValue = NumberUtils.createNumber(value).doubleValue();
        
        if(doubleValue < this.min || doubleValue > max) {
            return false;
        }
        
        return true;
    }
    
}