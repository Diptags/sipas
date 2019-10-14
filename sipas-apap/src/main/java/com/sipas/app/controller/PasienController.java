package com.sipas.app.controller;

import com.sipas.app.service.DiagnosisPenyakitService;
import com.sipas.app.service.PasienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PasienController {

    @Autowired
    private PasienService pasienService;

    @Autowired
    private DiagnosisPenyakitService diagnosisPenyakitService;

    // Membuka halaman utama SIPAS
    @GetMapping("/")
    public String showHomePage(){
        return "homepage";
    }

    // Membuka form untuk menambahkan pasien
    @PostMapping(value = "/pasien/tambah")
    public String showAddPasienForm() {
        return "pasien-add";
    }

    // Membuka detail dari pasien berdasarkan NIK pasien
    @GetMapping(value = "/pasien")
    public String showPasienInfoByNik(@RequestParam(value = "nikPasien") String nik, Model model) {
        return "pasien-detail";
    }

    // Membuka form untuk mengubah pasien
    @PostMapping(value = "/pasien/ubah/{nikPasien}")
    public String showChangePasienForm() {
        return "pasien-change";
    }

    // Membuka form untuk menambah diagnosis penyakit pasien
    @PostMapping(value = "/pasien/{nikPasien}/tambah-diagnosis")
    public String showAddDiagnosisPenyakitForm() {
        return "pasien-add-diagnosis";
    }

    // Mencari pasien berdasarkan Asuransi dan/atau diagnosis penyakit
    @GetMapping(value = "/pasien/cari")
    public String showPasienInfoByAsuransiDiagnosis(
            @RequestParam(value = "idAsuransi") Long idAsuransi,
            @RequestParam(value = "idDiagnosis") Long idDiagnosis,
            Model model) {
        return "pasien-find-asuransi-diagnosis";
    }

    // Menampilkan jumlah pasien laki - laki dan perempuan di suatu diagnosis
    @GetMapping(value = "/pasien/cari/termuda-tertua")
    public String showPasienInfoByGenderDiagnosis(
            @RequestParam(value = "idAsuransi") Long idAsuransi,
            Model model) {
        return "pasien-find-gender-diagnosis";
    }

}
