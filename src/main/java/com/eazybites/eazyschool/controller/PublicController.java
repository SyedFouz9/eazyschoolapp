package com.eazybites.eazyschool.controller;


import com.eazybites.eazyschool.model.Person;
import com.eazybites.eazyschool.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("public")
public class PublicController
{
    @Autowired
    PersonService personService;
    @RequestMapping(method = RequestMethod.GET,value = "/register")
    public String registerUser(Model model){
        model.addAttribute("person",new Person());
        return "register.html";
    }

    @RequestMapping(method = RequestMethod.POST,value = "/createUser")
    public String createUser(@Valid @ModelAttribute("person") Person person, Errors errors){

        if (errors.hasErrors()){
            return "register.html";
        }
        boolean isSaved=personService.createNewPerson(person);

        if(isSaved){
            return "redirect:/login?register=true";
        }else {
            return "register.html";
        }


    }
}
