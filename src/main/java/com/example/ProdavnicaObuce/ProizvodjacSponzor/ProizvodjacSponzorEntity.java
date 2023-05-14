package com.example.ProdavnicaObuce.ProizvodjacSponzor;

import com.example.ProdavnicaObuce.Proizvodjac.ProizvodjacEntity;
import com.example.ProdavnicaObuce.Sponzor.SponzorEntity;

import javax.persistence.*;

@Entity
@Table(name = "proizvodjacSponzor")
public class ProizvodjacSponzorEntity {
    @EmbeddedId
    ProizvodjacSponzor id = new ProizvodjacSponzor();

    @ManyToOne
    @MapsId("proizvodjacId")
    @JoinColumn(name = "proizvodjac_id")
    ProizvodjacEntity proizvodjac;

    @ManyToOne
    @MapsId("sponzorId")
    @JoinColumn(name = "sponzor_id")
    SponzorEntity sponzor;

    public ProizvodjacSponzorEntity() {
    }

    public ProizvodjacSponzorEntity(ProizvodjacSponzor id, ProizvodjacEntity proizvodjac,
                                    SponzorEntity sponzor) {
        this.id = id;
        this.proizvodjac = proizvodjac;
        this.sponzor = sponzor;
    }

    public ProizvodjacSponzorEntity(ProizvodjacEntity proizvodjac, SponzorEntity sponzor) {
        this.proizvodjac = proizvodjac;
        this.sponzor = sponzor;
    }

    public ProizvodjacSponzor getId() {
        return id;
    }

    public void setId(ProizvodjacSponzor id) {
        this.id = id;
    }

    public ProizvodjacEntity getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(ProizvodjacEntity proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public SponzorEntity getSponzor() {
        return sponzor;
    }

    public void setSponzor(SponzorEntity sponzor) {
        this.sponzor = sponzor;
    }
}