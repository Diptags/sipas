package com.sipas.app.repository;

import com.sipas.app.model.PasienModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PasienDb extends JpaRepository<PasienModel, Long> {
    PasienModel findByIdPasien(Long idPasien);
    PasienModel findByNik(String nik);
}
