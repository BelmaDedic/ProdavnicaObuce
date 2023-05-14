package com.example.ProdavnicaObuce.Sponzor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SponzorServiceImpl implements SponzorService {
    @Autowired
    private SponzorRepository sponzorRepository;

    @Override
    public void addSponzor(SponzorEntity sponzor) {
        sponzorRepository.save(sponzor);
    }

    @Override
    public List<SponzorEntity> getAllSponzori() {
        return sponzorRepository.findAll();
    }

    @Override
    public void deleteSponzor(Integer id) {
        sponzorRepository.deleteById(id);
    }

    @Override
    public void updateSponzor(Integer id, SponzorEntity sponzor) {
        sponzorRepository.findById(id)
                .ifPresent(noviSponzor -> {
                    noviSponzor.setNaziv(sponzor.getNaziv());
                    noviSponzor.setEmail(sponzor.getEmail());
                    noviSponzor.setProizvodjac_sponzor(sponzor.getProizvodjac_sponzor());
                    noviSponzor.setProjekti(sponzor.getProjekti());

                    sponzorRepository.save(noviSponzor);
                });
    }
}
