package com.example.ProdavnicaObuce.Proizvodjac;

import com.example.ProdavnicaObuce.Obuca.ObucaEntity;
import com.example.ProdavnicaObuce.ProizvodjacSponzor.ProizvodjacSponzorEntity;
import com.example.ProdavnicaObuce.Sponzor.SponzorEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "proizvodjac")
public class ProizvodjacEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String naziv, osnivac, sjediste;
    @JsonIgnore
    @OneToMany(targetEntity = ObucaEntity.class, mappedBy = "proizvodjac")
    private List<ObucaEntity> obuca = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "proizvodjacSponzor", joinColumns = {@JoinColumn(name = "proizvodjac_id")},
            inverseJoinColumns = {@JoinColumn(name = "sponzor_id")})
    @JsonIgnore
    private Set<SponzorEntity> sponzori = new HashSet<>();

    @JsonIgnore
    @OneToMany(targetEntity = ProizvodjacSponzorEntity.class, mappedBy = "proizvodjac")
    private Set<ProizvodjacSponzorEntity> proizvodjac_sponzor = new HashSet<>();

    public ProizvodjacEntity() {
    }

    public ProizvodjacEntity(Integer id, String naziv, String osnivac, String sjediste,
                             List<ObucaEntity> obuca, Set<SponzorEntity> sponzori,
                             Set<ProizvodjacSponzorEntity> proizvodjac_sponzor) {
        this.id = id;
        this.naziv = naziv;
        this.osnivac = osnivac;
        this.sjediste = sjediste;
        this.obuca = obuca;
        this.sponzori = sponzori;
        this.proizvodjac_sponzor = proizvodjac_sponzor;
    }

    public ProizvodjacEntity(String naziv, String osnivac, String sjediste, List<ObucaEntity> obuca,
                             Set<SponzorEntity> sponzori, Set<ProizvodjacSponzorEntity> proizvodjac_sponzor) {
        this.naziv = naziv;
        this.osnivac = osnivac;
        this.sjediste = sjediste;
        this.obuca = obuca;
        this.sponzori = sponzori;
        this.proizvodjac_sponzor = proizvodjac_sponzor;
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

    public String getOsnivac() {
        return osnivac;
    }

    public void setOsnivac(String osnivac) {
        this.osnivac = osnivac;
    }

    public String getSjediste() {
        return sjediste;
    }

    public void setSjediste(String sjediste) {
        this.sjediste = sjediste;
    }

    public List<ObucaEntity> getObuca() {
        return obuca;
    }

    public void setObuca(List<ObucaEntity> obuca) {
        this.obuca = obuca;
    }

    public Set<SponzorEntity> getSponzori() {
        return sponzori;
    }

    public void setSponzori(Set<SponzorEntity> sponzori) {
        this.sponzori = sponzori;
    }

    public Set<ProizvodjacSponzorEntity> getProizvodjac_sponzor() {
        return proizvodjac_sponzor;
    }

    public void setProizvodjac_sponzor(Set<ProizvodjacSponzorEntity> proizvodjac_sponzor) {
        this.proizvodjac_sponzor = proizvodjac_sponzor;
    }
}
