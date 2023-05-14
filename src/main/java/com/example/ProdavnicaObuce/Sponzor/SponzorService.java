package com.example.ProdavnicaObuce.Sponzor;

import java.util.List;

public interface SponzorService {
    void addSponzor(SponzorEntity sponzor);

    List<SponzorEntity> getAllSponzori();

    void deleteSponzor(Integer id);

    void updateSponzor(Integer id, SponzorEntity sponzor);
}
