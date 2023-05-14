package com.example.ProdavnicaObuce.ProizvodjacSponzor;

import com.example.ProdavnicaObuce.Sponzor.SponzorEntity;
import com.example.ProdavnicaObuce.User.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProizvodjacSponzorController {
    @Autowired
    private ProizvodjacSponzorService proizvodjacSponzorService;

    @PostMapping("addProizvodjacSponzor/{idProizvodjac}/{idSponzor}")
    public void addProizvodjacSponzor(@PathVariable Integer idProizvodjac, @PathVariable Integer idSponzor) {
        proizvodjacSponzorService.addProizvodjacSponzor(idProizvodjac, idSponzor);
    }

    @GetMapping("getAlLProizvodjacISponzori")
    public List<ProizvodjacSponzorEntity> getAllProizvodjaciSponzori() {
        return proizvodjacSponzorService.getAllProizvodjaciSponzori();
    }

    @DeleteMapping("deleteProizvodjacSponzor/{idProizvodjac}/{idSponzor}")
    public void deleteProizvodjacSponzor(@PathVariable Integer idProizvodjac, @PathVariable Integer idSponzor)
    {
        proizvodjacSponzorService.deleteProizvodjacSponzor(idProizvodjac, idSponzor);
    }

    @PutMapping("updateProizvodjacSponzor/{proizvodjacId}/{sponzorId}/{noviProizvodjacId}/{noviSponzorId}")
    public void updateProizvodjacSponzor(@PathVariable Integer proizvodjacId, @PathVariable Integer sponzorId,
                                         @PathVariable Integer noviProizvodjacId,
                                         @PathVariable Integer noviSponzorId) {
        proizvodjacSponzorService.updateProizvodjacSponzor(proizvodjacId, sponzorId, noviProizvodjacId,
                noviSponzorId);
    }
}
