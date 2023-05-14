package com.example.ProdavnicaObuce.Proizvodjac;

import com.example.ProdavnicaObuce.Obuca.ObucaEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProizvodjacController {
    @Autowired
    private ProizvodjacService proizvodjacService;

    @PostMapping("addProizvodjac")
    public void addProizvodjac(@RequestBody ProizvodjacEntity proizvodjac) {
        proizvodjacService.addProizvodjac(proizvodjac);
    }

    @GetMapping("getAllProizvodjaci")
    public List<ProizvodjacEntity> getAllProizvodjaci() {
        return proizvodjacService.getAllProizvodjaci();
    }

    @DeleteMapping("deleteProizvodjac/{id}")
    public void deleteProizvodjac(@PathVariable(value = "id") Integer id) {
        proizvodjacService.deleteProizvodjac(id);
    }

    @PutMapping("updateProizvodjac/{id}")
    public void updateProizvodjac(@PathVariable Integer id, @RequestBody ProizvodjacEntity proizvodjac) {
        proizvodjacService.updateProizvodjac(id, proizvodjac);
    }
}
