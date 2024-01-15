package com.eazybites.eazyschool.service;

import com.eazybites.eazyschool.constants.EazySchoolConstants;
import com.eazybites.eazyschool.model.Contact;
import com.eazybites.eazyschool.repository.JpaContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    //private ContactRepository contactRepository;
    private JpaContactRepository contactRepository;

    @Autowired
    public ContactService(JpaContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public boolean saveContact(Contact contact) {
        contact.setStatus(EazySchoolConstants.OPEN);
        contact.setCreatedAt(LocalDateTime.now());
        contact.setCreatedBy(EazySchoolConstants.ANONYMOUS);
        Contact savedContact = contactRepository.save(contact);
        if (savedContact.getContactId() > 0) {
            return true;
        }
        return false;
    }

    public List<Contact> findMsgsWithOpenStatus() {
        List<Contact> contactMsgs = contactRepository.findByStatus(EazySchoolConstants.OPEN);
        return contactMsgs;
    }
    public boolean updateMsgStatus(int contactId, String updatedBy) {
        boolean isUpdated = false;
        Optional<Contact> contact = contactRepository.findById(contactId);
        contact.ifPresent(contact1 -> contact1.setStatus(EazySchoolConstants.CLOSE));
        contact.ifPresent(contact1 -> contact1.setUpdatedBy(updatedBy));
        Contact updatedContact = contactRepository.save(contact.get());
        if (updatedContact.getUpdatedBy() != null) {
            isUpdated = true;
        }
        return isUpdated;
    }
}
