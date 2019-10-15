package com.sipas.app.controller;

import com.sipas.app.model.DiagnosisPenyakitModel;
import com.sipas.app.model.PasienModel;
import com.sipas.app.service.DiagnosisPenyakitService;
import com.sipas.app.service.PasienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PasienController {

    @Autowired
    private PasienService pasienService;

    @Autowired
    private DiagnosisPenyakitService diagnosisPenyakitService;

    // Membuka halaman utama SIPAS
    @GetMapping("/")
    public String showHomePage(Model model){
        List<PasienModel> pasienList = pasienService.getPasienList();
        model.addAttribute("pasienList", pasienList);
        return "homepage";
    }

    // Membuka form untuk menambahkan pasien
    @GetMapping(value = "/pasien/tambah")
    public String showAddPasienForm() {
        return "pasien-add";
    }

    // Membuka detail dari pasien berdasarkan NIK pasien
    @GetMapping(value = "/pasien")
    public String showPasienInfoByNik(@RequestParam(value = "nikPasien") String nikPasien, Model model) {
        PasienModel pasien = pasienService.getPasienByNikPasien(nikPasien);
        model.addAttribute("pasien", pasien);
        return "pasien-detail";
    }

    // Membuka form untuk mengubah pasien
    @PostMapping(value = "/pasien/ubah/{nikPasien}")
    public String showChangePasienForm() {
        return "pasien-change";
    }

    // Membuka form untuk menambah diagnosis penyakit pasien
    @GetMapping(value = "/pasien/{nikPasien}/tambah-diagnosis")
    public String showAddDiagnosisPenyakitForm(@PathVariable String nikPasien,
                                               @ModelAttribute("selectedDiagnosisPenyakit") DiagnosisPenyakitModel selectedDiagnosisPenyakit,
                                               Model model)
    {
        PasienModel pasien = pasienService.getPasienByNikPasien(nikPasien);
        List<DiagnosisPenyakitModel> diagnosisPenyakitList = diagnosisPenyakitService.getDiagnosisPenyakitList();

        model.addAttribute("pasien", pasien);
        model.addAttribute("diagnosisPenyakitList", diagnosisPenyakitList);
        return "pasien-add-diagnosis";
    }

    // Melakukan submit form penambahan diagnosis penyakit pasien
    @PostMapping(value = "/pasien/{nikPasien}/tambah-diagnosis")
    public String submitAddDiagnosisPenyakitForm(@ModelAttribute("selectedDiagnosisPenyakit") DiagnosisPenyakitModel selectedDiagnosisPenyakit,
                                                 Model model)
    {
        String[] temporaryData = selectedDiagnosisPenyakit.getKode().split(" ");
        Long idDiagnosisPenyakit = (Long) Long.parseLong(temporaryData[0]);
        Long idPasien = (Long) Long.parseLong(temporaryData[1]);

        DiagnosisPenyakitModel penyakit = diagnosisPenyakitService.getDiagnosisPenyakitByIdDiagnosisPenyakit(idDiagnosisPenyakit);
        PasienModel pasien = pasienService.getPasienByIdPasien(idPasien);

        pasienService.addDiagnosisToPasien(pasien, penyakit);
        model.addAttribute("pesan", "Data diagnosis penyakit berhasil ditambahkan kepada pasien");
        return "message-info";
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
