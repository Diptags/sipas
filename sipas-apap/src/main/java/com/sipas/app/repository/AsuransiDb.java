package com.sipas.app.repository;

import com.sipas.app.model.AsuransiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsuransiDb extends JpaRepository<AsuransiModel, Long> {
    AsuransiModel findByIdAsuransi(Long idAsuransi);
}
