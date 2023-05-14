package com.example.ProdavnicaObuce.Obuca;

import com.example.ProdavnicaObuce.Prodavnica.ProdavnicaEntity;
import com.example.ProdavnicaObuce.Proizvodjac.ProizvodjacEntity;
import com.example.ProdavnicaObuce.User.UserEntity;

import javax.persistence.*;

@Entity
@Table(name = "obuca")
public class ObucaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String naziv, boja;
    private Integer kolicina, velicina;
    private Double cijena;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
    private UserEntity user;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
    private ProdavnicaEntity prodavnica;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
    private ProizvodjacEntity proizvodjac;

    public ObucaEntity() {
    }

    public ObucaEntity(Integer id, String naziv, String boja, Integer kolicina, Integer velicina, Double cijena,
                       UserEntity user, ProdavnicaEntity prodavnica, ProizvodjacEntity proizvodjac) {
        this.id = id;
        this.naziv = naziv;
        this.boja = boja;
        this.kolicina = kolicina;
        this.velicina = velicina;
        this.cijena = cijena;
        this.user = user;
        this.prodavnica = prodavnica;
        this.proizvodjac = proizvodjac;
    }

    public ObucaEntity(String naziv, String boja, Integer kolicina, Integer velicina, Double cijena,
                       UserEntity user, ProdavnicaEntity prodavnica, ProizvodjacEntity proizvodjac) {
        this.naziv = naziv;
        this.boja = boja;
        this.kolicina = kolicina;
        this.velicina = velicina;
        this.cijena = cijena;
        this.user = user;
        this.prodavnica = prodavnica;
        this.proizvodjac = proizvodjac;
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

    public String getBoja() {
        return boja;
    }

    public void setBoja(String boja) {
        this.boja = boja;
    }

    public Integer getKolicina() {
        return kolicina;
    }

    public void setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
    }

    public Integer getVelicina() {
        return velicina;
    }

    public void setVelicina(Integer velicina) {
        this.velicina = velicina;
    }

    public Double getCijena() {
        return cijena;
    }

    public void setCijena(Double cijena) {
        this.cijena = cijena;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public ProdavnicaEntity getProdavnica() {
        return prodavnica;
    }

    public void setProdavnica(ProdavnicaEntity prodavnica) {
        this.prodavnica = prodavnica;
    }

    public ProizvodjacEntity getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(ProizvodjacEntity proizvodjac) {
        this.proizvodjac = proizvodjac;
    }
}