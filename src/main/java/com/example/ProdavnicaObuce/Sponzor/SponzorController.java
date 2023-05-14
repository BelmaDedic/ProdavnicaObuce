package com.example.ProdavnicaObuce.Sponzor;

import com.example.ProdavnicaObuce.Proizvodjac.ProizvodjacEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SponzorController {
    @Autowired
    private SponzorService sponzorService;

    @PostMapping("addSponzor")
    public void addSponzor(@RequestBody SponzorEntity sponzor) {
        sponzorService.addSponzor(sponzor);
    }

    @GetMapping("getAllSponzori")
    public List<SponzorEntity> getAllSponzori() {
        return sponzorService.getAllSponzori();
    }

    @DeleteMapping("deleteSponzor/{id}")
    public void deleteSponzor(@PathVariable(value = "id") Integer id) {
        sponzorService.deleteSponzor(id);
    }

    @PutMapping("updateSponzor/{id}")
    public void updateSponzor(@PathVariable Integer id, @RequestBody SponzorEntity sponzor) {
        sponzorService.updateSponzor(id, sponzor);
    }
}
