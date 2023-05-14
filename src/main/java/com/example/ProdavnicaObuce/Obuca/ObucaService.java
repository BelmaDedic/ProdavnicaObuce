package com.example.ProdavnicaObuce.Obuca;

import com.example.ProdavnicaObuce.Prodavnica.ProdavnicaEntity;

import java.util.HashMap;
import java.util.List;

public interface ObucaService {

    void addObuca(ObucaEntity obuca);

    List<ObucaEntity> getAllObuca();

    void deleteObuca(Integer id);

    void updateObuca(Integer id, ObucaEntity obuca);

    List<ObucaEntity> startWithP();

    List<ObucaEntity> rasponCijena(Integer min, Integer max);

    List<ObucaEntity> pretragaPoObuciGrupiIKorisniku(Integer obucaId, Integer korisnikId,
                                                     Integer prodavnicaId);

    List<ObucaEntity> pretragaObuce(String naziv, Integer korisnikId, Integer prodavnicaId);

    List<ObucaEntity> provjeraUsera(String username, String password);

    List<ObucaEntity> pretraga(DocumentSearchParam searchParam);

    List<IspisProjection> provjeraAdmin();

    List<ProdavnicaProizvodjacProjection> getProdavnicaProizvodjac(String naziv);

    List<ProizvodjacUser> getUserProizvodjac(String naziv);

    List<ObucaEntity> pretragaObuceParametri(SearhObuca searchParam);

    List<String> gradCijena();

    List<Integer> userIds();

    List<PretragaObuceProjection> pretragaObuceVelicina(String naziv, Integer velicina);

//    HashMap<String, List<String>> drzavaProizvodjac();

    Integer brojNeprodatih();

    List<ProjectionForAllEntities> pretragaPoSvemu(SearchByAll searchParam);
}
