package com.sipas.app.repository;

import com.sipas.app.model.DiagnosisPenyakitModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiagnosisPenyakitDb extends JpaRepository<DiagnosisPenyakitModel, Long> {
    List<DiagnosisPenyakitModel> findByIdDiagnosisPenyakit(Long idDiagnosisPenyakit);
}
