package com.eazybites.eazyschool.repository;

import com.eazybites.eazyschool.model.Holiday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

public class HolidayRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Holiday> displayHolidays() {
        String sql = "SELECT * FROM HOLIDAYS";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Holiday.class));
    }
}
