package com.eazybites.eazyschool.controller;

import com.eazybites.eazyschool.model.Contact;
import com.eazybites.eazyschool.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {
    ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/contact"})
    public String contactController(Model model) {
        return "contact.html";
    }

    @RequestMapping(method = RequestMethod.POST, value = {"/saveMsg"})
    public ModelAndView saveContact(Contact contact, ModelAndView model) {
        boolean isSaved = contactService.saveContact(contact);
        model.addObject("contact", contact);
        model.setViewName("redirect:/contact");
        return model;
    }

}
