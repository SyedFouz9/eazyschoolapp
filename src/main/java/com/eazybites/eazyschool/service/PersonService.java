package com.eazybites.eazyschool.service;


import com.eazybites.eazyschool.constants.EazySchoolConstants;
import com.eazybites.eazyschool.model.Person;
import com.eazybites.eazyschool.model.Roles;
import com.eazybites.eazyschool.repository.PersonRepository;
import com.eazybites.eazyschool.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private RolesRepository rolesRepository;

    public boolean createNewPerson(Person person) {
        Roles role = rolesRepository.findByRoleName(EazySchoolConstants.STUDENT_ROLE);
        person.setRole(role);
        Person savedPerson=personRepository.save(person);
        if (savedPerson.getPersonId() > 0) {
            return true;
        }
        return false;
    }
}
