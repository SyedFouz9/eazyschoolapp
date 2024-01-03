package com.eazybites.eazyschool.controller;

import com.eazybites.eazyschool.model.Holiday;
import com.eazybites.eazyschool.model.Type;
import com.eazybites.eazyschool.service.HolidayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HolidayController {

    private HolidayServiceImpl holidayService;

    @Autowired
    public HolidayController(HolidayServiceImpl holidayService) {
        this.holidayService = holidayService;
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/holidays/{display}", "/holidays"})
    public String courseController(Model model, @PathVariable(required = false) String display) {

        if (display != null && display.equals("all")) {
            model.addAttribute(Type.FEDERAL.name().toLowerCase(), true);
            model.addAttribute(Type.FESTIVAL.name().toLowerCase(), true);
        } else if (display != null && display.equals(Type.FEDERAL.name().toLowerCase())) {
            model.addAttribute(Type.FEDERAL.name().toLowerCase(), true);
        } else if (display != null && display.equals(Type.FESTIVAL.name().toLowerCase())) {
            model.addAttribute(Type.FESTIVAL.name().toLowerCase(), true);
        }
        //TODO: data base implementation, fetch holidays from data base
        List<Holiday> holidayList = Arrays.asList(
                new Holiday("Jan 1", "New Year's Day", Type.FESTIVAL),
                new Holiday("Oct 31", "Halloween", Type.FESTIVAL),
                new Holiday("Nov 24", "Thanksgiving Day", Type.FESTIVAL),
                new Holiday("Dec 25", "Christmas", Type.FESTIVAL),
                new Holiday("Jan 17", "Martin Luther King Jr. Day", Type.FEDERAL),
                new Holiday("July 4", "Independence Day", Type.FEDERAL),
                new Holiday("Sep 5", "Labor Day", Type.FEDERAL),
                new Holiday("Nov 11", "Veterans Day", Type.FEDERAL));

        for (Type holidayType : Type.values()) {
            model.addAttribute(holidayType.name(), holidayList.stream().filter(holiday -> holiday.getType().equals(holidayType)).collect(Collectors.toList()));
        }
        return "holidays.html";
    }

}
