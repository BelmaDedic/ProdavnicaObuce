package com.example.ProdavnicaObuce.Proizvodjac;

import java.util.List;

public interface ProizvodjacService {
    void addProizvodjac(ProizvodjacEntity proizvodjac);

    List<ProizvodjacEntity> getAllProizvodjaci();

    void deleteProizvodjac(Integer id);

    void updateProizvodjac(Integer id, ProizvodjacEntity proizvodjac);
}
