package com.sipas.app.service;

import com.sipas.app.model.AsuransiModel;
import com.sipas.app.model.DiagnosisPenyakitModel;
import com.sipas.app.model.EmergencyContactModel;
import com.sipas.app.model.PasienModel;
import com.sipas.app.other.AddPasienHandler;
import com.sipas.app.other.ChangePasienHandler;
import com.sipas.app.repository.AsuransiDb;
import com.sipas.app.repository.EmergencyContactDb;
import com.sipas.app.repository.PasienDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class PasienServiceImpl implements PasienService {

    @Autowired
    PasienDb pasienDb;

    @Autowired
    EmergencyContactDb emergencyContactDb;

    @Autowired
    AsuransiDb asuransiDb;

    @Override
    public String addPasien(AddPasienHandler dataHandler) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String tanggalLahirStr = dataHandler.getTanggalLahirPasien();
        Date tanggalLahirPasien = null;

        try {
            tanggalLahirPasien = formatter.parse(tanggalLahirStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Membuat emergency contact baru
        EmergencyContactModel contact = new EmergencyContactModel();
        contact.setNama(dataHandler.getNamaEmergency());
        contact.setNik(dataHandler.getNikEmergency());
        contact.setNomorHp(dataHandler.getNomorHpEmergency());
        emergencyContactDb.save(contact);

        // Membuat pasien baru
        PasienModel pasien = new PasienModel();

        String kodePasien = createKodePasien(dataHandler.getJenisKelaminPasien(), tanggalLahirStr);
        pasien.setKode(kodePasien);

        pasien.setNama(dataHandler.getNamaPasien());
        pasien.setNik(dataHandler.getNikPasien());
        pasien.setJenisKelamin(dataHandler.getJenisKelaminPasien());
        pasien.setTanggalLahir(tanggalLahirPasien);
        pasien.setTempatLahir(dataHandler.getTempatLahirPasien());
        pasien.setEmergencyContact(contact);

        // Memasukkan asuransi ke data pasien
        List<AsuransiModel> listAsuransi = new ArrayList<>();

        AsuransiModel targetAsuransi = asuransiDb.findByIdAsuransi(dataHandler.getIdAsuransi());
        listAsuransi.add(targetAsuransi);
        pasien.setListAsuransi(listAsuransi);
        pasienDb.save(pasien);

        return kodePasien;
    }

    @Override
    public List<PasienModel> getPasienList() {
        return pasienDb.findAll();
    }

    @Override
    public PasienModel getPasienByIdPasien(Long idPasien) {
        return pasienDb.findByIdPasien(idPasien);
    }

    @Override
    public PasienModel getPasienByNikPasien(String nik) {
        return pasienDb.findByNik(nik);
    }

    @Override
    public void addDiagnosisToPasien(PasienModel pasien, DiagnosisPenyakitModel diagnosisPenyakit) {
        pasien.addDiagnosisPenyakit(diagnosisPenyakit);
        pasienDb.save(pasien);
    }

    @Override
    public String changePasienData(PasienModel pasien, ChangePasienHandler dataHandler) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String tanggalLahirStr = dataHandler.getTanggalLahirPasien();
        Date tanggalLahirPasien = null;

        try {
            tanggalLahirPasien = formatter.parse(tanggalLahirStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        PasienModel pasienTarget = pasienDb.findByIdPasien(pasien.getIdPasien());
        EmergencyContactModel contactTarget = emergencyContactDb.findByIdEmergencyContact(
                pasien.getEmergencyContact().getIdEmergencyContact()
        );

        Timestamp newDateOfBirth = new Timestamp(tanggalLahirPasien.getTime());

        String kodePasien = pasienTarget.getKode();

        if (!newDateOfBirth.equals(pasienTarget.getTanggalLahir())) {
            kodePasien = createKodePasien(pasienTarget.getJenisKelamin(), tanggalLahirStr);
            pasienTarget.setKode(kodePasien);
        }

        contactTarget.setNama(dataHandler.getNamaEmergency());
        contactTarget.setNik(dataHandler.getNikEmergency());
        contactTarget.setNomorHp(dataHandler.getNomorHpEmergency());
        emergencyContactDb.save(contactTarget);

        pasienTarget.setNama(dataHandler.getNamaPasien());
        pasienTarget.setNik(dataHandler.getNikPasien());
        pasienTarget.setJenisKelamin(dataHandler.getJenisKelaminPasien());
        pasienTarget.setTanggalLahir(tanggalLahirPasien);
        pasienTarget.setTempatLahir(dataHandler.getTempatLahirPasien());
        pasienTarget.setEmergencyContact(contactTarget);
        pasienDb.save(pasienTarget);
        return kodePasien;
    }

    @Override
    public void deletePasien(PasienModel pasien) {
        pasienDb.delete(pasien);
    }

    @Override
    public String createKodePasien(int jenisKelamin, String dateOfBirth) {
        String kodePasien = "2024"; // Inisial kode 2019 + 5

        // Checksum (2 Karakter terakhir) Generator
        final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final int N = alphabet.length();

        Random r = new Random();

        String checksum = "";
        for (int i = 0; i < 2; i++) {
            checksum += alphabet.charAt(r.nextInt(N));
        }

        String[] tanggalLahirSplit = dateOfBirth.substring(0, 10).split("/");

        kodePasien += tanggalLahirSplit[0];
        kodePasien += tanggalLahirSplit[1];
        kodePasien += tanggalLahirSplit[2].substring(2, 4);
        kodePasien += String.valueOf(jenisKelamin);
        kodePasien += checksum;
        return kodePasien;
    }
}
