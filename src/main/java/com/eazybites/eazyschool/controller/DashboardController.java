package com.eazybites.eazyschool.controller;

import com.eazybites.eazyschool.model.Person;
import com.eazybites.eazyschool.repository.PersonRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DashboardController {
    @Autowired
    PersonRepository personRepository;
    @RequestMapping(method = RequestMethod.GET, value = "/dashboard")
    public String viewDashboard(Model model, Authentication authentication, HttpSession session) {
        Person person= personRepository.findByName(authentication.getName());
        session.setAttribute("loggedInPerson",person);
        model.addAttribute("username", authentication.getName());
        model.addAttribute("roles", authentication.getAuthorities().toString());
        return "dashboard.html";
    }

}
