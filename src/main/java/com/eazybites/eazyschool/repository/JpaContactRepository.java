package com.eazybites.eazyschool.repository;

import com.eazybites.eazyschool.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaContactRepository extends JpaRepository<Contact, Integer> {

    List<Contact> findByStatus(String status);




}
