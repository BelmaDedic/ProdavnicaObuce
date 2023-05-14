package com.example.ProdavnicaObuce.Drzava;

import java.util.List;

public interface DrzavaService {
    void addDrzava(DrzavaEntity drzava);

    List<DrzavaEntity> getAllDrzave();

    void deleteDrzava(Integer id);

    void updateDrzava(Integer id, DrzavaEntity drzava);
}
