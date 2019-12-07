package com.sipas.app.service;

import com.sipas.app.model.EmergencyContactModel;

import java.util.List;

public interface EmergencyContactService {
    void addEmergencyContact(EmergencyContactModel emergencyContact);
    List<EmergencyContactModel> getEmergencyContactList();
    EmergencyContactModel getEmergencyContactByIdEmergencyContact(Long idEmergencyContact);
    void deleteEmergencyContact(EmergencyContactModel emergencyContact);
}
