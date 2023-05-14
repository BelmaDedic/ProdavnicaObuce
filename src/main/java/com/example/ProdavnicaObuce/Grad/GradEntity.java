package com.example.ProdavnicaObuce.Grad;

import com.example.ProdavnicaObuce.Drzava.DrzavaEntity;
import com.example.ProdavnicaObuce.Prodavnica.ProdavnicaEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "grad")
public class GradEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String naziv, postanskiBroj;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
    private DrzavaEntity drzava;

    @JsonIgnore
    @OneToMany(targetEntity = ProdavnicaEntity.class, mappedBy = "grad")
    private List<ProdavnicaEntity> prodavnica = new ArrayList<>();

    public GradEntity() {
    }

    public GradEntity(Integer id, String naziv, String postanskiBroj, DrzavaEntity drzava,
                      List<ProdavnicaEntity> prodavnica) {
        this.id = id;
        this.naziv = naziv;
        this.postanskiBroj = postanskiBroj;
        this.drzava = drzava;
        this.prodavnica = prodavnica;
    }

    public GradEntity(String naziv, String postanskiBroj, DrzavaEntity drzava,
                      List<ProdavnicaEntity> prodavnica) {
        this.naziv = naziv;
        this.postanskiBroj = postanskiBroj;
        this.drzava = drzava;
        this.prodavnica = prodavnica;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getPostanskiBroj() {
        return postanskiBroj;
    }

    public void setPostanskiBroj(String postanskiBroj) {
        this.postanskiBroj = postanskiBroj;
    }

    public DrzavaEntity getDrzava() {
        return drzava;
    }

    public void setDrzava(DrzavaEntity drzava) {
        this.drzava = drzava;
    }

    public List<ProdavnicaEntity> getProdavnica() {
        return prodavnica;
    }

    public void setObuca(List<ProdavnicaEntity> prodavnica) {
        this.prodavnica = prodavnica;
    }
}
