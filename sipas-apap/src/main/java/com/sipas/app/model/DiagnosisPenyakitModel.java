package com.sipas.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "diagnosisPenyakit")
public class DiagnosisPenyakitModel implements Serializable {

    @ManyToMany(mappedBy = "listDiagnosisPenyakit")
    List<PasienModel> listPenderita;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "kode", nullable = false)
    private String kode;

    @NotNull
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull
    @Column(name = "nomorHp", nullable = false)
    private String nomorHp;

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

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomorHp() {
        return nomorHp;
    }

    public void setNomorHp(String nomorHp) {
        this.nomorHp = nomorHp;
    }

    public List<PasienModel> getListPenderita() {
        return listPenderita;
    }

    public void setListPenderita(List<PasienModel> listPenderita) {
        this.listPenderita = listPenderita;
    }
}