package com.example.ProdavnicaObuce.ProizvodjacSponzor;

import com.example.ProdavnicaObuce.Proizvodjac.ProizvodjacEntity;
import com.example.ProdavnicaObuce.Proizvodjac.ProizvodjacRepository;
import com.example.ProdavnicaObuce.Sponzor.SponzorEntity;
import com.example.ProdavnicaObuce.Sponzor.SponzorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProizvodjacSponzorServiceImpl implements ProizvodjacSponzorService {
    @Autowired
    private ProizvodjacSponzorRepository proizvodjacSponzorRepository;

    @Autowired
    private ProizvodjacRepository proizvodjacRepository;

    @Autowired
    private SponzorRepository sponzorRepository;

    @Override
    public void addProizvodjacSponzor(Integer idProizvodjac, Integer idSponzor) {
        ProizvodjacEntity proizvodjac = proizvodjacRepository.findById(idProizvodjac)
                .orElse(new ProizvodjacEntity());
        SponzorEntity sponzor = sponzorRepository.findById(idSponzor).orElse(new SponzorEntity());
        ProizvodjacSponzorEntity proizvodjacSponzor = new ProizvodjacSponzorEntity(proizvodjac, sponzor);
        proizvodjacSponzorRepository.save(proizvodjacSponzor);
    }

    @Override
    public List<ProizvodjacSponzorEntity> getAllProizvodjaciSponzori() {
        return proizvodjacSponzorRepository.findAll();
    }

    @Override
    public void deleteProizvodjacSponzor(Integer idProizvodjac, Integer idSponzor) {
        proizvodjacSponzorRepository.deleteProizvodjacSponzor(idProizvodjac, idSponzor);
    }

    @Override
    public void updateProizvodjacSponzor(Integer proizvodjacId, Integer sponzorId,
                                         Integer noviProizvodjacId, Integer noviSponzorId) {
        proizvodjacSponzorRepository.updateProizvodjacSponzor(proizvodjacId, sponzorId, noviProizvodjacId,
                noviSponzorId);
    }
}
