package com.sipas.app.controller;

import com.sipas.app.service.DiagnosisPenyakitService;
import com.sipas.app.service.PasienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DiagnosisPenyakitController {

    @Autowired
    private PasienService pasienService;

    @Autowired
    private DiagnosisPenyakitService diagnosisPenyakitService;

    // Menampilkan seluruh diagnosis penyakit
    @GetMapping(value = "/diagnosis-penyakit-all")
    public String showAllDiagnosisPenyakit() {
        return "diagnosispenyakit-all";
    }

    // Menampilkan diagnosis penyakit berdasarkan id diagnosis
    @GetMapping(value = "/diagnosis-penyakit")
    public String showDiagnosisPenyakitById(@RequestParam(value = "idDiagnosis") Long id, Model model) {
        return "diagnosispenyakit-detail";
    }

    // Membuka form untuk menambahkan diagnosis penyakit dari pasien
    @PostMapping(value = "/diagnosis-penyakit/tambah")
    public String showAddDiagnosisPenyakitForm() {
        return "diagnosispenyakit-add";
    }

    // Melakukan penghapusan data diagnosis penyakit
    @PostMapping(value = "/diagnosis-penyakit/hapus")
    public String deleteDiagnosisPenyakit() {
        return "diagnosispenyakit-delete";
    }

}
