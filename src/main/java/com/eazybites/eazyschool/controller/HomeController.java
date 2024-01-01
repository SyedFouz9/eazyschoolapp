package com.eazybites.eazyschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(method = RequestMethod.GET, name = "")
    public ModelAndView homeController(ModelAndView modelAndView) {

        modelAndView.setViewName("home.html");
        return modelAndView;
    }
}
