package com.eazybites.eazyschool.service.annotation;

import com.eazybites.eazyschool.validation.FieldsValueMatchValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {FieldsValueMatchValidator.class})
@Target({METHOD, FIELD})
@Retention(RUNTIME)
public @interface FieldsValueMatch {
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String message() default "Fields values don't match";

    String field();

    String fieldMatch();

    @Target({ElementType.TYPE})
    @Retention(RUNTIME)
    @interface List{
        FieldsValueMatch[] value();
    }
}
