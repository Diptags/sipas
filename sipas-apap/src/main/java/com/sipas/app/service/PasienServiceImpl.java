package com.sipas.app.service;

import com.sipas.app.model.PasienModel;
import com.sipas.app.repository.PasienDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasienServiceImpl implements PasienService{

    @Autowired
    PasienDb pasienDb;

    @Override
    public void addPasien(PasienModel pasien){
        pasienDb.save(pasien);
    }

    @Override
    public List<PasienModel> getPasienList(){
        return pasienDb.findAll();
    }

    @Override
    public PasienModel getPasienByIdPasien(Long idPasien){
        return pasienDb.findByIdPasien(idPasien);
    }

    @Override
    public PasienModel getPasienByNikPasien(String nik){
        return pasienDb.findByNik(nik);
    }

    @Override
    public void deletePasien(PasienModel pasien){
        pasienDb.delete(pasien);
    }
}
