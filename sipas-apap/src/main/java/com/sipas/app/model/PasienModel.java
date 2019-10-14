package com.sipas.app.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pasien")
public class PasienModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPasien;

    @NotNull
    @Size(max = 13)
    @Column(name = "kode", nullable = false)
    private String kode;

    @NotNull
    @Column(name = "nik", nullable = false)
    private String nik;

    @NotNull
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull
    @Column(name = "jenisKelamin", nullable = false)
    private Integer jenisKelamin;

    @NotNull
    @Column(name = "tanggalLahir", nullable = false)
    private Date tanggalLahir;

    @NotNull
    @Column(name = "tempatLahir", nullable = false)
    private String tempatLahir;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idEmergencyContact", referencedColumnName = "id")
    private EmergencyContactModel emergencyContact;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "pasien_asuransi",
            joinColumns = @JoinColumn(name = "pasienId"),
            inverseJoinColumns = @JoinColumn(name = "asuransiId"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<AsuransiModel> listAsuransi;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "pasien_diagnosis_penyakit",
            joinColumns = @JoinColumn(name = "pasienId"),
            inverseJoinColumns = @JoinColumn(name = "diagnosisPenyakitId"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<DiagnosisPenyakitModel> listDiagnosisPenyakit;

    public Long getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(Long idPasien) {
        this.idPasien = idPasien;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(Integer jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public EmergencyContactModel getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(EmergencyContactModel emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public List<AsuransiModel> getListAsuransi() {
        return listAsuransi;
    }

    public void setListAsuransi(List<AsuransiModel> listAsuransi) {
        this.listAsuransi = listAsuransi;
    }

    public List<DiagnosisPenyakitModel> getListDiagnosisPenyakit() {
        return listDiagnosisPenyakit;
    }

    public void setListDiagnosisPenyakit(List<DiagnosisPenyakitModel> listDiagnosisPenyakit) {
        this.listDiagnosisPenyakit = listDiagnosisPenyakit;
    }
}