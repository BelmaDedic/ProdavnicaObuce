package com.example.ProdavnicaObuce.Drzava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrzavaServiceImpl implements DrzavaService {
    @Autowired
    private DrzavaRepository drzavaRepository;

    @Override
    public void addDrzava(DrzavaEntity drzava) {
        drzavaRepository.save(drzava);
    }

    @Override
    public List<DrzavaEntity> getAllDrzave() {
        return drzavaRepository.findAll();
    }

    @Override
    public void deleteDrzava(Integer id) {
        drzavaRepository.deleteById(id);
    }

    @Override
    public void updateDrzava(Integer id, DrzavaEntity drzava) {
        drzavaRepository.findById(id)
                .ifPresent(novaDrzava -> {
                    novaDrzava.setNaziv(drzava.getNaziv());
                    novaDrzava.setGlavniGrad(drzava.getGlavniGrad());
                    novaDrzava.setValuta(drzava.getValuta());

                    drzavaRepository.save(novaDrzava);
                });
    }
}
