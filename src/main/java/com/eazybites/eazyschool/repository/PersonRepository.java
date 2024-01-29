package com.eazybites.eazyschool.repository;

import com.eazybites.eazyschool.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    Person findByName(String name);
    Person findByEmail(String email);

}
