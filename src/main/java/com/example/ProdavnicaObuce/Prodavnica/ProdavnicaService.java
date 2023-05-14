package com.example.ProdavnicaObuce.Prodavnica;

import java.util.List;

public interface ProdavnicaService {
    void addProdavnica(ProdavnicaEntity prodavnica);

    List<ProdavnicaEntity> getAllProdavnice();

    void deleteProdavnica(Integer id);

    void updateProdavnica(Integer id, ProdavnicaEntity prodavnica);
}
