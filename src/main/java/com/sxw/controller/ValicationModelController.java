package com.sxw.controller;

import com.sxw.model.People;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.Set;

@RequestMapping("/model")
@RestController
public class ValicationModelController {

    @RequestMapping("/demo3")
    public void demo3(){
        People people = new People();
        people.setAge("111");
        people.setHigh(150);
        people.setLength("ABCDE");
        people.setList(new ArrayList<String>(){{add("111");add("222");add("333");add("444");add("555");add("666");}});

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        Set<ConstraintViolation<People>> violationSet = validator.validate(people);

        for (ConstraintViolation<People> model : violationSet) {
            System.out.println(model.getMessage());
        }
    }
}
