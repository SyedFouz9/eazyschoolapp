package com.eazybites.eazyschool.validation;


import com.eazybites.eazyschool.service.annotation.FieldsValueMatch;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class FieldsValueMatchValidator implements ConstraintValidator<FieldsValueMatch, Object> {
    private String field;
    private String fieldMatch;

    @Override
    public void initialize(FieldsValueMatch constraintAnnotation) {
        field = constraintAnnotation.field();
        fieldMatch = constraintAnnotation.fieldMatch();
    }
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Object fieldValue = new BeanWrapperImpl(value).getPropertyValue(field);
        Object fieldMatchValue = new BeanWrapperImpl(value).getPropertyValue(fieldMatch);

        if (fieldValue != null) {
            if (fieldValue.toString().startsWith("$2a")) {
                return true;
            } else {
                return fieldValue.equals(fieldMatchValue);
            }
        } else {
            return fieldMatchValue == null;
        }

    }
}
