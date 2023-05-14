package com.example.ProdavnicaObuce.Obuca;

import com.example.ProdavnicaObuce.Prodavnica.ProdavnicaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class ObucaController {
    @Autowired
    private ObucaService obucaService;

    @PostMapping("addObuca")
    public void addObuca(@RequestBody ObucaEntity obuca) {
        obucaService.addObuca(obuca);
    }

    @GetMapping("allObuca")
    public List<ObucaEntity> getAllObuca() {
        return obucaService.getAllObuca();
    }

    @DeleteMapping("deleteObuca/{id}")
    public void deteleObuca(@PathVariable(value = "id") Integer id) {
        obucaService.deleteObuca(id);
    }

    @PutMapping("updateObuca/{id}")
    public void updateObuca(@PathVariable Integer id, @RequestBody ObucaEntity obuca) {
        obucaService.updateObuca(id, obuca);
    }

    @GetMapping("startsWithP")
    public List<ObucaEntity> startWithP() {
        return obucaService.startWithP();
    }

    @GetMapping("uslovObuca/{min}/{max}")
    public List<ObucaEntity> rasponCijena(@PathVariable Integer min, @PathVariable Integer max) {
        return obucaService.rasponCijena(min, max);
    }

    @GetMapping("pretragaObucaIdKorisnikIdProdavnicaId/{obucaId}/{korisnikId}/{prodavnicaId}")
    public List<ObucaEntity> pretragaPoObuciGrupiIKorisniku(@PathVariable Integer obucaId,
                                                            @PathVariable Integer korisnikId,
                                                            @PathVariable Integer prodavnicaId) {
        return obucaService.pretragaPoObuciGrupiIKorisniku(obucaId, korisnikId, prodavnicaId);
    }

    @GetMapping("pretragaObuce/{naziv}/{korisnikId}/{prodavnicaId}")
    public List<ObucaEntity> pretragaObuce(@PathVariable String naziv, @PathVariable Integer korisnikId,
                                           @PathVariable Integer prodavnicaId) {
        return obucaService.pretragaObuce(naziv, korisnikId, prodavnicaId);
    }

    @GetMapping("provjeraUsera")
    public List<ObucaEntity> provjeraUsera(@RequestHeader String username, @RequestHeader String password) {
        return obucaService.provjeraUsera(username, password);
    }

    @PostMapping("pretraga")
    public List<ObucaEntity> pretraga(@RequestBody (required=false) DocumentSearchParam searchParam) {
        return obucaService.pretraga(searchParam);
    }

    @GetMapping("ispisZaAdmina")
    public List<IspisProjection> provjeraAdmin(@RequestHeader String username, @RequestHeader String password)
            throws IllegalAccessException {
        if(username.equals("admin") && password.equals("admin")) {
            return obucaService.provjeraAdmin();
        } else {
            throw new IllegalAccessException();
        }
    }

    @GetMapping("getProdavnicaProizvodjac/{naziv}")
    public List<ProdavnicaProizvodjacProjection> getProdavnicaProizvodjac(@PathVariable String naziv) {
        return obucaService.getProdavnicaProizvodjac(naziv);
    }

    @GetMapping("getUserProizvodjac/{naziv}")
    public List<ProizvodjacUser> getUserProizvodjac(@PathVariable String naziv) {
        return obucaService.getUserProizvodjac(naziv);
    }

    @PostMapping("pretragaObuceParametri")
    public List<ObucaEntity> pretragaObuceParametri(@RequestBody SearhObuca searchParam) {
        return obucaService.pretragaObuceParametri(searchParam);
    }

    @GetMapping("gradCijena")
    public List<String> gradCijena() {
        return obucaService.gradCijena();
    }

    @GetMapping("userIds")
    public List<Integer> userIds() {
        return obucaService.userIds();
    }

    @GetMapping("pretragaObucaVelicina/{naziv}/{velicina}")
    public List<PretragaObuceProjection> pretragaObuceVelicina(@PathVariable String naziv,
                                                               @PathVariable Integer velicina) {
        return obucaService.pretragaObuceVelicina(naziv, velicina);
    }

//    @GetMapping("drzavaProizvodjac")
//    public HashMap<String, List<String>> drzavaProizvodjac() {
//        return obucaService.drzavaProizvodjac();
//    }

    @GetMapping("brojNeprodateObuce")
    public Integer brojNeprodatih() {
        return obucaService.brojNeprodatih();
    }

    @PostMapping("pretragaSviEntiteti")
    public List<ProjectionForAllEntities> pretragaPoSvemu(@RequestBody SearchByAll searchParam) {
        return obucaService.pretragaPoSvemu(searchParam);
    }
}