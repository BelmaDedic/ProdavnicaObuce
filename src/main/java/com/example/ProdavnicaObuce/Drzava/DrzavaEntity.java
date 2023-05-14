package com.example.ProdavnicaObuce.Drzava;

import com.example.ProdavnicaObuce.Grad.GradEntity;
import com.example.ProdavnicaObuce.Obuca.ObucaEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "drzava")
public class DrzavaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String naziv, glavniGrad, valuta;

    @JsonIgnore
    @OneToMany(targetEntity = GradEntity.class, mappedBy = "drzava")
    private List<GradEntity> grad = new ArrayList<>();

    public DrzavaEntity() {
    }

    public DrzavaEntity(Integer id, String naziv, String glavniGrad, String valuta, List<GradEntity> grad) {
        this.id = id;
        this.naziv = naziv;
        this.glavniGrad = glavniGrad;
        this.valuta = valuta;
        this.grad = grad;
    }

    public DrzavaEntity(String naziv, String glavniGrad, String valuta, List<GradEntity> grad) {
        this.naziv = naziv;
        this.glavniGrad = glavniGrad;
        this.valuta = valuta;
        this.grad = grad;
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

    public String getGlavniGrad() {
        return glavniGrad;
    }

    public void setGlavniGrad(String glavniGrad) {
        this.glavniGrad = glavniGrad;
    }

    public String getValuta() {
        return valuta;
    }

    public void setValuta(String valuta) {
        this.valuta = valuta;
    }

    public List<GradEntity> getGrad() {
        return grad;
    }

    public void setGrad(List<GradEntity> grad) {
        this.grad = grad;
    }
}
