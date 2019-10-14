package com.sipas.app.service;

import com.sipas.app.model.AsuransiModel;

import java.util.List;

public interface AsuransiService {
    void addAsuransi(AsuransiModel asuransi);
    List<AsuransiModel> getAsuransiList();
    AsuransiModel getAsuransiByIdAsuransi(Long idAsuransi);
    void deleteAsuransi(AsuransiModel asuransi);
}
