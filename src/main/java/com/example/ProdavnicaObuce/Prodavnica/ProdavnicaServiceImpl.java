package com.example.ProdavnicaObuce.Prodavnica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdavnicaServiceImpl implements ProdavnicaService{
    @Autowired
    private ProdavnicaRepository prodavnicaRepository;

    @Override
    public void addProdavnica(ProdavnicaEntity prodavnica) {
        prodavnicaRepository.save(prodavnica);
    }

    @Override
    public List<ProdavnicaEntity> getAllProdavnice() {
        return prodavnicaRepository.findAll();
    }

    @Override
    public void deleteProdavnica(Integer id) {
        prodavnicaRepository.deleteById(id);
    }

    @Override
    public void updateProdavnica(Integer id, ProdavnicaEntity prodavnica) {
        prodavnicaRepository.findById(id)
                .ifPresent(novaProdavnica -> {
                    novaProdavnica.setNaziv(prodavnica.getNaziv());
                    novaProdavnica.setAdresa(prodavnica.getAdresa());
                    novaProdavnica.setGrad(prodavnica.getGrad());
                    novaProdavnica.setObuca(prodavnica.getObuca());

                    prodavnicaRepository.save(novaProdavnica);
                });
    }
}
