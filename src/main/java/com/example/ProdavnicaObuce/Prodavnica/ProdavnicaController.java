package com.example.ProdavnicaObuce.Prodavnica;

import com.example.ProdavnicaObuce.User.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdavnicaController {
    @Autowired
    private ProdavnicaService prodavnicaService;

    @PostMapping("addProdavnica")
    public void addProdavnica(@RequestBody ProdavnicaEntity prodavnica) {
        prodavnicaService.addProdavnica(prodavnica);
    }

    @GetMapping("getAllProdavnice")
    public List<ProdavnicaEntity> getAllProdavnice() {
        return prodavnicaService.getAllProdavnice();
    }

    @DeleteMapping("deleteProdavnica/{id}")
    public void deleteProdavnica(@PathVariable(value = "id") Integer id) {
        prodavnicaService.deleteProdavnica(id);
    }

    @PutMapping("updateProdavnica/{id}/{prodavnica}")
    public void updateProdavnica(@PathVariable Integer id, @RequestBody ProdavnicaEntity prodavnica) {
        prodavnicaService.updateProdavnica(id, prodavnica);
    }
}
