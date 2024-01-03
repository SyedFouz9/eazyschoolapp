package com.eazybites.eazyschool.controller;

import com.eazybites.eazyschool.model.Contact;
import com.eazybites.eazyschool.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactController {
    @Autowired
    ContactService contactService;

    @RequestMapping(method = RequestMethod.GET, value = {"/contact"})
    public String contactController(Model model) {
        return "contact.html";
    }

    @RequestMapping(method = RequestMethod.POST, value = {"/saveMsg"})
    public String saveContact(Contact contact, Model model) {
        contactService.saveContact(contact);
        model.addAttribute("contact", contact);
        return "contact.html";
    }

}
