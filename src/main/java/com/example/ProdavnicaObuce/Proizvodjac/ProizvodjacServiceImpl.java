package com.example.ProdavnicaObuce.Proizvodjac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProizvodjacServiceImpl implements ProizvodjacService {
    @Autowired
    private ProizvodjacRepository proizvodjacRepository;

    @Override
    public void addProizvodjac(ProizvodjacEntity proizvodjac) {
        proizvodjacRepository.save(proizvodjac);
    }

    @Override
    public List<ProizvodjacEntity> getAllProizvodjaci() {
        return proizvodjacRepository.findAll();
    }

    @Override
    public void deleteProizvodjac(Integer id) {
        proizvodjacRepository.deleteById(id);
    }

    @Override
    public void updateProizvodjac(Integer id, ProizvodjacEntity proizvodjac) {
        proizvodjacRepository.findById(id)
                .ifPresent(noviProizvodjac -> {
                    noviProizvodjac.setNaziv(proizvodjac.getNaziv());
                    noviProizvodjac.setOsnivac(proizvodjac.getOsnivac());
                    noviProizvodjac.setSjediste(proizvodjac.getSjediste());

                    proizvodjacRepository.save(noviProizvodjac);
                });
    }
}
