package com.example.ProdavnicaObuce.ProizvodjacSponzor;

import java.util.List;

public interface ProizvodjacSponzorService {

    void addProizvodjacSponzor(Integer idProizvodjac, Integer idSponzor);

    List<ProizvodjacSponzorEntity> getAllProizvodjaciSponzori();

    void deleteProizvodjacSponzor(Integer idProizvodjac, Integer idSponzor);
    void updateProizvodjacSponzor(Integer proizvodjacId, Integer sponzorId,
                                  Integer noviProizvodjacId, Integer noviSponzorId);
}
