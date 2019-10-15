package com.sipas.app.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "asuransi")
public class AsuransiModel implements Serializable {

    @ManyToMany(mappedBy = "listAsuransi")
    List<PasienModel> listPemilik;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAsuransi;

    @NotNull
    @Size(max = 255)
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull
    @Size(max = 255)
    @Column(name = "jenis", nullable = false)
    private String jenis;

    @ManyToMany(mappedBy = "listAsuransi", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<PasienModel> listPasien;

    public Long getIdAsuransi() {
        return idAsuransi;
    }

    public void setIdAsuransi(Long idAsuransi) {
        this.idAsuransi = idAsuransi;
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