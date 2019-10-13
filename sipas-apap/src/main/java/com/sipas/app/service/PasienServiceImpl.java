package com.sipas.app.service;

import com.sipas.app.model.PasienModel;
import com.sipas.app.repository.PasienDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasienServiceImpl implements PasienService{

    @Autowired
    PasienDb pasienDb;

    @Override
    public void addPasien(PasienModel pasien){
        pasienDb.save(pasien);
    }

    @Override
    public void deletePasien(PasienModel pasien){
        pasienDb.delete(pasien);
    }
}
