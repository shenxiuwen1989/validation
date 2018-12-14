/*
 * 
 * @Copyright:   Copyright © 2007-2018 ky-express.com.All Rights Reserved.
 * @Date:        2018年7月18日 下午6:52:48
 * @Author:      lucius.lv
 * @Version:     1.0.0.0
 * @Description: Initialize
 */
package com.sxw.validator;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.internal.util.logging.Log;
import org.hibernate.validator.internal.util.logging.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.invoke.MethodHandles;

public class StringSplitLengthConstraintValidator implements ConstraintValidator<StringSplitLength, String> {

    private static final Log LOG = LoggerFactory.make(MethodHandles.lookup());
    
    private int max;
    private String separator;
    private boolean allowNullable;
    
    @Override
    public void initialize(StringSplitLength descriptionsLength) {
        max = descriptionsLength.max();
        separator = descriptionsLength.separator();
        allowNullable = descriptionsLength.allowNullable();
        validateParameters();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext cxt) {
        
        //如果字符串为空校验不通过
        if(!allowNullable && StringUtils.isEmpty(value)) {
            return false;
        }
        //按照指定字符串分割大于max也校验不通过
        if(StringUtils.countMatches(value, separator) >= max){
            return false;
        }
        return true;
    }
    
    private void validateParameters() {
        if ( max < 0 ) {
            throw LOG.getMaxCannotBeNegativeException();
        }
    }
    
}