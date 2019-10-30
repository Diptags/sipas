package com.sipas.app.other;

public class AddPasienHandler {

    private String nikPasien;
    private String namaPasien;
    private Integer jenisKelaminPasien;
    private String tanggalLahirPasien;
    private String tempatLahirPasien;

    private String nikEmergency;
    private String namaEmergency;
    private String nomorHpEmergency;

    private Long idAsuransi;

    public Long getIdAsuransi() {
        return idAsuransi;
    }

    public void setIdAsuransi(Long idAsuransi) {
        this.idAsuransi = idAsuransi;
    }

    public String getNikPasien() {
        return nikPasien;
    }

    public void setNikPasien(String nikPasien) {
        this.nikPasien = nikPasien;
    }

    public String getNamaPasien() {
        return namaPasien;
    }

    public void setNamaPasien(String namaPasien) {
        this.namaPasien = namaPasien;
    }

    public Integer getJenisKelaminPasien() {
        return jenisKelaminPasien;
    }

    public void setJenisKelaminPasien(Integer jenisKelaminPasien) {
        this.jenisKelaminPasien = jenisKelaminPasien;
    }

    public String getTanggalLahirPasien() {
        return tanggalLahirPasien;
    }

    public void setTanggalLahirPasien(String tanggalLahirPasien) {
        this.tanggalLahirPasien = tanggalLahirPasien;
    }

    public String getTempatLahirPasien() {
        return tempatLahirPasien;
    }

    public void setTempatLahirPasien(String tempatLahirPasien) {
        this.tempatLahirPasien = tempatLahirPasien;
    }

    public String getNikEmergency() {
        return nikEmergency;
    }

    public void setNikEmergency(String nikEmergency) {
        this.nikEmergency = nikEmergency;
    }

    public String getNamaEmergency() {
        return namaEmergency;
    }

    public void setNamaEmergency(String namaEmergency) {
        this.namaEmergency = namaEmergency;
    }

    public String getNomorHpEmergency() {
        return nomorHpEmergency;
    }

    public void setNomorHpEmergency(String nomorHpEmergency) {
        this.nomorHpEmergency = nomorHpEmergency;
    }
}
