package com.example.ProdavnicaObuce.Prodavnica;

import com.example.ProdavnicaObuce.Grad.GradEntity;
import com.example.ProdavnicaObuce.Obuca.ObucaEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "prodavnica")
public class ProdavnicaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String naziv, adresa;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
    private GradEntity grad;

    @JsonIgnore
    @OneToMany(targetEntity = ObucaEntity.class, mappedBy = "prodavnica")
    private List<ObucaEntity> obuca = new ArrayList<>();

    public ProdavnicaEntity() {
    }

    public ProdavnicaEntity(Integer id, String naziv, String adresa, GradEntity grad,
                            List<ObucaEntity> obuca) {
        this.id = id;
        this.naziv = naziv;
        this.adresa = adresa;
        this.grad = grad;
        this.obuca = obuca;
    }

    public ProdavnicaEntity(String naziv, String adresa, GradEntity grad, List<ObucaEntity> obuca) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.grad = grad;
        this.obuca = obuca;
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

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public GradEntity getGrad() {
        return grad;
    }

    public void setGrad(GradEntity grad) {
        this.grad = grad;
    }

    public List<ObucaEntity> getObuca() {
        return obuca;
    }

    public void setObuca(List<ObucaEntity> obuca) {
        this.obuca = obuca;
    }
}