package com.example.ProdavnicaObuce.Grad;

import com.example.ProdavnicaObuce.Obuca.ObucaEntity;
import com.example.ProdavnicaObuce.Proizvodjac.ProizvodjacEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@RestController
public class GradController {
    @Autowired
    private GradService gradService;

    @PostMapping("addGrad")
    public void addGrad(@RequestBody GradEntity grad) {
        gradService.addGrad(grad);
    }

    @GetMapping("getAllGradovi")
    public List<GradEntity> getAllGradovi() {
        return gradService.getAllGradovi();
    }

    @DeleteMapping("deleteGrad/{id}")
    public void deleteGrad(@PathVariable(value = "id") Integer id) {
        gradService.deleteGrad(id);
    }

    @PutMapping("updateGrad/{id}")
    public void updateGrad(@PathVariable Integer id, @RequestBody GradEntity grad) {
        gradService.updateGrad(id, grad);
    }
}
