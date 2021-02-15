package com.dwes.security.error.validator;


import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.dwes.security.error.validator.label.RoleLabel;



public class RoleValidator implements ConstraintValidator<RoleLabel, String> {

    List<String> roles = Arrays.asList("ADMIN", "USER");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        return roles.contains(value);

    }
}
