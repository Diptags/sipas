package com.sipas.app.service;

import com.sipas.app.model.EmergencyContactModel;
import com.sipas.app.repository.EmergencyContactDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmergencyContactServiceImpl implements EmergencyContactService {

    @Autowired
    EmergencyContactDb emergencyContactDb;

    @Override
    public void addEmergencyContact(EmergencyContactModel contact) {
        emergencyContactDb.save(contact);
    }

    @Override
    public List<EmergencyContactModel> getEmergencyContactList() {
        return emergencyContactDb.findAll();
    }

    @Override
    public EmergencyContactModel getEmergencyContactByIdEmergencyContact(Long idEmergencyContact) {
        return emergencyContactDb.findByIdEmergencyContact(idEmergencyContact);
    }

    @Override
    public void deleteEmergencyContact(EmergencyContactModel contact) {
        emergencyContactDb.delete(contact);
    }
}
