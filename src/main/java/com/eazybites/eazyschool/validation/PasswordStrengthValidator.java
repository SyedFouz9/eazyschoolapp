package com.eazybites.eazyschool.validation;


import com.eazybites.eazyschool.service.annotation.PasswordValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class PasswordStrengthValidator implements ConstraintValidator<PasswordValidator, String> {

    List<String> weakPasswords;
    @Override
    public void initialize(PasswordValidator constraintAnnotation) {
        weakPasswords= Arrays.asList("12345","admin","password","qwerty");
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return  (value != null && !(weakPasswords.contains(value)));
    }
}
