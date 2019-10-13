package com.sipas.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "diagnosisPenyakit")
public class DiagnosisPenyakitModel implements Serializable {

    @ManyToMany(mappedBy = "listDiagnosisPenyakit")
    private List<PasienModel> listPenderita;

    @Id
    @Size(max = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDiagnosisPenyakit;

    @NotNull
    @Size(max = 255)
    @Column(name = "kode", nullable = false)
    private String kode;

    @NotNull
    @Size(max = 255)
    @Column(name = "nama", nullable = false)
    private String nama;

    public Long getIdDiagnosisPenyakit() {
        return idDiagnosisPenyakit;
    }

    public void setIdDiagnosisPenyakit(Long idDiagnosisPenyakit) {
        this.idDiagnosisPenyakit = idDiagnosisPenyakit;
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

    public List<PasienModel> getListPenderita() {
        return listPenderita;
    }

    public void setListPenderita(List<PasienModel> listPenderita) {
        this.listPenderita = listPenderita;
    }
}