package com.eazybites.eazyschool.repository;


import com.eazybites.eazyschool.model.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaHolidayRepository extends JpaRepository<Holiday,String> {

}
