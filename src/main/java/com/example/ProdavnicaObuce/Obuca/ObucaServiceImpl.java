package com.example.ProdavnicaObuce.Obuca;

import com.example.ProdavnicaObuce.Drzava.DrzavaEntity;
import com.example.ProdavnicaObuce.Drzava.DrzavaRepository;
import com.example.ProdavnicaObuce.Grad.GradEntity;
import com.example.ProdavnicaObuce.Prodavnica.ProdavnicaEntity;
import com.example.ProdavnicaObuce.Prodavnica.ProdavnicaRepository;
import com.example.ProdavnicaObuce.Proizvodjac.ProizvodjacEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObucaServiceImpl implements ObucaService {
    @Autowired
    private ObucaRepository obucaRepository;

    @Autowired
    private DrzavaRepository drzavaRepository;

    @Autowired
    private ProdavnicaRepository prodavnicaRepository;

    @Override
    public void addObuca(ObucaEntity obuca) {
        obucaRepository.save(obuca);
    }

    @Override
    public List<ObucaEntity> getAllObuca() {
            return obucaRepository.findAll();
    }

    @Override
    public void deleteObuca(Integer id) {
        obucaRepository.deleteById(id);
    }

    @Override
    public void updateObuca(Integer id, ObucaEntity obuca) {
        obucaRepository.findById(id)
                .ifPresent(obuca2 -> {
                    obuca2.setNaziv(obuca.getNaziv());
                    obuca2.setBoja(obuca.getBoja());
                    obuca2.setCijena(obuca.getCijena());
                    obuca2.setKolicina(obuca.getKolicina());
                    obuca2.setVelicina(obuca.getVelicina());

                    obucaRepository.save(obuca2);
                });
    }

    @Override
    public List<ObucaEntity> startWithP() {
        List<ObucaEntity> startWithP = obucaRepository.findAll();

        return startWithP.stream().filter(obuca -> obuca.getNaziv().startsWith("p"))
                .collect(Collectors.toList());
    }

    @Override
    public List<ObucaEntity> rasponCijena(Integer min, Integer max) {
        List<ObucaEntity> obuca = obucaRepository.findAll();
        List<ObucaEntity> uslovObuca = new ArrayList<>();

        obuca.forEach(obuca2 -> {
            if(obuca2.getCijena() >= min && obuca2.getCijena() <= max) {
                uslovObuca.add(obuca2);
            }
        });

        return uslovObuca;
    }

    @Override
    public List<ObucaEntity> pretragaPoObuciGrupiIKorisniku(Integer obucaId, Integer korisnikId,
                                                            Integer prodavnicaId) {
        return obucaRepository.pretragaPoObuciGrupiIKorisniku(obucaId, korisnikId, prodavnicaId);
    }

    @Override
    public List<ObucaEntity> pretragaObuce(String naziv, Integer korisnikId, Integer prodavnicaId) {
        return obucaRepository.pretragaObuce(naziv, korisnikId, prodavnicaId);
    }

    @Override
    public List<ObucaEntity> provjeraUsera(String username, String password) {
        return obucaRepository.provjeraUsera(username, password);
    }

    @Override
    public List<ObucaEntity> pretraga(DocumentSearchParam searchParam) {
        return obucaRepository.pretraga(searchParam);
    }

    @Override
    public List<IspisProjection> provjeraAdmin() {
        return obucaRepository.provjeraAdmin();
    }

    @Override
    public List<ProdavnicaProizvodjacProjection> getProdavnicaProizvodjac(String naziv) {
        return obucaRepository.getProdavnicaProizvodjac(naziv);
    }

    @Override
    public List<ProizvodjacUser> getUserProizvodjac(String naziv) {
        return obucaRepository.getUserProizvodjac(naziv);
    }

    @Override
    public List<ObucaEntity> pretragaObuceParametri(SearhObuca searchParam) {
        return obucaRepository.pretragaObuceParametri(searchParam);
    }

    @Override
    public List<String> gradCijena() {
        List<IspisProjection> rezultat = obucaRepository.gradCijena();

        List<String> stringovi = new ArrayList<>();

        for(int i = 0; i < rezultat.size(); i++) {
            Double dolar = 0.0, euro = 0.0, cijena = 0.0;
            String grad = rezultat.get(i).getGrad();

            cijena = rezultat.get(i).getCijena();
            dolar = Double.valueOf(Math.round(((rezultat.get(i).getCijena() / 1.97) * 100.0) / 100.0));
            euro = Double.valueOf(Math.round(((rezultat.get(i).getCijena() / 1.96) * 100.0) / 100.0));

            String recenica = String.format("U gradu %s potroseno je %sKM, sto je jednako %s$, a to " +
                    "je jednako %sEUR", grad, cijena, dolar, euro);

            stringovi.add(recenica);
        }
        return stringovi;
    }

    @Override
    public List<Integer> userIds() {
        List<ObucaEntity> obuca = obucaRepository.findAll();

        List<Integer> userId = obuca.stream().filter((obuca2) -> obuca2.getUser() != null)
                .map((obuca2) -> obuca2.getUser().getId()).collect(Collectors.toList());
        return userId;
    }

    @Override
    public List<PretragaObuceProjection> pretragaObuceVelicina(String naziv, Integer velicina) {
        return obucaRepository.pretragaObuceVelicina(naziv, velicina);
    }

//    @Override
//    public HashMap<String, List<String>> drzavaProizvodjac() {
//        HashMap<String, List<String>> drzavaProizvodjac = new HashMap<>();
//
//        List<DrzavaEntity> drzava = drzavaRepository.findAll();
//
//        for(int i = 0; i < drzava.size(); i++) {
//            List<Integer> gradIds = drzava.get(i).getGrad().stream().map(GradEntity::getId)
//                    .collect(Collectors.toList());
//            List<ProdavnicaEntity> prodavnica = prodavnicaRepository.findByIds(gradIds);
//            List<Integer> prodavnicaIds = prodavnica.stream().map(ProdavnicaEntity::getId)
//                    .collect(Collectors.toList());
//            System.out.println(prodavnicaIds);
//            List<ObucaEntity> obuca = obucaRepository.searchObucaByIdsIn(prodavnicaIds);
//            List<ProizvodjacEntity> proizvodjac = obuca.stream().map(ObucaEntity::getProizvodjac)
//                    .collect(Collectors.toList());
//
//            drzavaProizvodjac.put(drzava.get(i).getNaziv(), proizvodjac.stream().map(ProizvodjacEntity
//                    ::getNaziv).collect(Collectors.toList()));
//        }
//        return drzavaProizvodjac;
//    }

    @Override
    public Integer brojNeprodatih() {
        List<ObucaEntity> obuca = obucaRepository.findAll();
        Integer brojNeprodatih = 0;
        for(int i = 0; i < obuca.size(); i++) {
            if(obuca.get(i).getUser() == null) {
                brojNeprodatih++;
            }
        }
        return brojNeprodatih;
    }

    @Override
    public List<ProjectionForAllEntities> pretragaPoSvemu(SearchByAll searchParam) {
        return obucaRepository.pretragaPoSvemu(searchParam);
    }
}