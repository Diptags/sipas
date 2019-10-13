package com.sipas.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "asuransi")
public class AsuransiModel implements Serializable {

    @ManyToMany(mappedBy = "listAsuransi")
    List<PasienModel> listPemilik;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull
    @Column(name = "jenis", nullable = false)
    private String jenis;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public List<PasienModel> getListPemilik() {
        return listPemilik;
    }

    public void setListPemilik(List<PasienModel> listPemilik) {
        this.listPemilik = listPemilik;
    }
}