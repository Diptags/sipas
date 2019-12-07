package com.sipas.app.repository;

import com.sipas.app.model.EmergencyContactModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmergencyContactDb extends JpaRepository<EmergencyContactModel, Long> {
    EmergencyContactModel findByIdEmergencyContact(Long idEmergencyContact);
}
