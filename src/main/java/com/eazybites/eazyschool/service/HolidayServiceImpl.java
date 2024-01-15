package com.eazybites.eazyschool.service;

import com.eazybites.eazyschool.model.Holiday;
import com.eazybites.eazyschool.repository.JpaHolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HolidayServiceImpl {
    @Autowired
    JpaHolidayRepository holidayRepository;

    public List<Holiday> displayHolidays() {
        return holidayRepository.findAll();
    }

}
