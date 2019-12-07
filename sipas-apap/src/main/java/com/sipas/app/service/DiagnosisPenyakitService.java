package com.sipas.app.service;

import com.sipas.app.model.DiagnosisPenyakitModel;

import java.util.List;

public interface DiagnosisPenyakitService {
    void addDiagnosisPenyakit(DiagnosisPenyakitModel diagnosisPenyakit);
    List<DiagnosisPenyakitModel> getDiagnosisPenyakitList();
    DiagnosisPenyakitModel getDiagnosisPenyakitByIdDiagnosisPenyakit(Long idDiagnosisPenyakit);
    void deleteDiagnosisPenyakit(Long idDiagnosisPenyakit);
}
