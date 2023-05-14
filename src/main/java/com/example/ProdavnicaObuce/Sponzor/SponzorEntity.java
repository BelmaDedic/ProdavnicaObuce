package com.example.ProdavnicaObuce.Sponzor;

import com.example.ProdavnicaObuce.Proizvodjac.ProizvodjacEntity;
import com.example.ProdavnicaObuce.ProizvodjacSponzor.ProizvodjacSponzorEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sponzor")
public class SponzorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String naziv, email;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "sponzori")
    @JsonIgnore
    private Set<ProizvodjacEntity> projekti = new HashSet<>();

    @JsonIgnore
    @OneToMany(targetEntity = ProizvodjacSponzorEntity.class, mappedBy = "sponzor")
    private Set<ProizvodjacSponzorEntity> proizvodjac_sponzor = new HashSet<>();

    public SponzorEntity() {
    }

    public SponzorEntity(Integer id, String naziv, String email, Set<ProizvodjacEntity> projekti,
                         Set<ProizvodjacSponzorEntity> proizvodjac_sponzor) {
        this.id = id;
        this.naziv = naziv;
        this.email = email;
        this.projekti = projekti;
        this.proizvodjac_sponzor = proizvodjac_sponzor;
    }

    public SponzorEntity(String naziv, String email, Set<ProizvodjacEntity> projekti,
                         Set<ProizvodjacSponzorEntity> proizvodjac_sponzor) {
        this.naziv = naziv;
        this.email = email;
        this.projekti = projekti;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<ProizvodjacEntity> getProjekti() {
        return projekti;
    }

    public void setProjekti(Set<ProizvodjacEntity> projekti) {
        this.projekti = projekti;
    }

    public Set<ProizvodjacSponzorEntity> getProizvodjac_sponzor() {
        return proizvodjac_sponzor;
    }

    public void setProizvodjac_sponzor(Set<ProizvodjacSponzorEntity> proizvodjac_sponzor) {
        this.proizvodjac_sponzor = proizvodjac_sponzor;
    }
}