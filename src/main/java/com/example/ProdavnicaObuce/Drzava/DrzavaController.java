package com.example.ProdavnicaObuce.Drzava;

import com.example.ProdavnicaObuce.Grad.GradEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DrzavaController {
    @Autowired
    private DrzavaService drzavaService;

    @PostMapping("addDrzava")
    public void addDrzava(@RequestBody DrzavaEntity drzava) {
        drzavaService.addDrzava(drzava);
    }

    @GetMapping("getAllDrzave")
    public List<DrzavaEntity> getAllDrzave() {
        return drzavaService.getAllDrzave();
    }

    @DeleteMapping("deleteDrzava/{id}")
    public void deleteDrzava(@PathVariable(value = "id") Integer id) {
        drzavaService.deleteDrzava(id);
    }

    @PutMapping("updateDrzava/{id}")
    public void updateDrzava(@PathVariable Integer id, @RequestBody DrzavaEntity drzava) {
        drzavaService.updateDrzava(id, drzava);
    }
}
