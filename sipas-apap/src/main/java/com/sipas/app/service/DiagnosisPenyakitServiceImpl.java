package com.sipas.app.service;

import com.sipas.app.model.DiagnosisPenyakitModel;
import com.sipas.app.repository.DiagnosisPenyakitDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiagnosisPenyakitServiceImpl implements DiagnosisPenyakitService{

    @Autowired
    DiagnosisPenyakitDb diagnosisPenyakitDb;

    @Override
    public void addDiagnosisPenyakit(DiagnosisPenyakitModel diagnosisPenyakit){
        diagnosisPenyakitDb.save(diagnosisPenyakit);
    }

    @Override
    public void deleteDiagnosisPenyakit(DiagnosisPenyakitModel diagnosisPenyakit){
        diagnosisPenyakitDb.delete(diagnosisPenyakit);
    }

}
