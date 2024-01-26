package com.eazybites.eazyschool.controller;

import com.eazybites.eazyschool.model.Contact;
import com.eazybites.eazyschool.service.ContactService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class ContactController {
    ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/contact"})
    public String contactController(Model model) {
        //for validation, need to create relationship between html and this object
        model.addAttribute("contact", new Contact());
        return "contact.html";
    }

    @RequestMapping(method = RequestMethod.POST, value = {"/saveMsg"})
    public String saveContact(@Valid @ModelAttribute("contact") Contact contact, Errors errors) {
        if (errors.hasErrors()) {
            log.error("Saving contact failed");
            return "contact.html";
        }
        contactService.saveContact(contact);
        return "redirect:/contact";
    }
    @RequestMapping("/displayMessages")
    public ModelAndView displayMessages() {
        List<Contact> contactMsgs = contactService.findMsgsWithOpenStatus();
        ModelAndView modelAndView = new ModelAndView("messages.html");
        modelAndView.addObject("contactMsgs", contactMsgs);
        return modelAndView;
    }
    @RequestMapping(method = RequestMethod.GET, value = "/closeMsg")
    public String closeMsg(@RequestParam(name = "id") int contactId, Authentication authentication) {
        contactService.updateMsgStatus(contactId);
        return "redirect:/displayMessages";
    }

}
