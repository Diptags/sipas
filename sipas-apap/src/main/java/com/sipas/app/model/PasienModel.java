package com.sipas.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "pasien")
public class PasienModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    private String jenisKelamin;

    @NotNull
    @Column(name = "tanggalLahir", nullable = false)
    private String tanggalLahir;

    @NotNull
    @Column(name = "tempatLahir", nullable = false)
    private String tempatLahir;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emergencyContactId", referencedColumnName = "id")
    private EmergencyContactModel emergencyContact;

    @ManyToMany
    @JoinTable(
            name = "pasien_asuransi",
            joinColumns = @JoinColumn(name = "pasienId"),
            inverseJoinColumns = @JoinColumn(name = "asuransiId"))
    private List<AsuransiModel> listAsuransi;

    @ManyToMany
    @JoinTable(
            name = "pasien_diagnosis",
            joinColumns = @JoinColumn(name = "pasienId"),
            inverseJoinColumns = @JoinColumn(name = "diagnosisPenyakitId"))
    private List<DiagnosisPenyakitModel> listDiagnosisPenyakit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
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