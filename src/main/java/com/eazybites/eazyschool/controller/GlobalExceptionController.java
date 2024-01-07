package com.eazybites.eazyschool.controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(Exception exception) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errormsg", exception.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
