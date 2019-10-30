package com.sipas.app.service;

import com.sipas.app.model.DiagnosisPenyakitModel;
import com.sipas.app.model.PasienModel;
import com.sipas.app.other.AddPasienHandler;
import com.sipas.app.other.ChangePasienHandler;

import java.util.List;

public interface PasienService {
    String addPasien(AddPasienHandler dataHandler);
    List<PasienModel> getPasienList();
    PasienModel getPasienByIdPasien(Long idPasien);
    PasienModel getPasienByNikPasien(String nik);
    void addDiagnosisToPasien(PasienModel pasien, DiagnosisPenyakitModel diagnosisPenyakit);
    String changePasienData(PasienModel pasien, ChangePasienHandler dataHandler);
    void deletePasien(PasienModel pasien);
    String createKodePasien(int jenisKelamin, String dateOfBirth);
}
