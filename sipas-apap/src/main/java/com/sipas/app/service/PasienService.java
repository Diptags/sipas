package com.sipas.app.service;

import com.sipas.app.model.DiagnosisPenyakitModel;
import com.sipas.app.model.PasienModel;

import java.util.List;

public interface PasienService {
    void addPasien(PasienModel pasien);
    List<PasienModel> getPasienList();
    PasienModel getPasienByIdPasien(Long idPasien);
    PasienModel getPasienByNikPasien(String nik);
    void addDiagnosisToPasien(PasienModel pasien, DiagnosisPenyakitModel diagnosisPenyakit);
    void deletePasien(PasienModel pasien);
}
