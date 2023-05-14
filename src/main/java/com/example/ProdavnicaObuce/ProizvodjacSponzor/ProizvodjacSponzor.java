package com.example.ProdavnicaObuce.ProizvodjacSponzor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProizvodjacSponzor implements Serializable {
    @Column(name = "proizvodjac_id")
    Integer proizvodjacId;

    @Column(name = "sponzor_id")
    Integer sponzorId;
}
