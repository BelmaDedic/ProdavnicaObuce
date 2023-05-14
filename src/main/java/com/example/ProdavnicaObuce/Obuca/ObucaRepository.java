package com.example.ProdavnicaObuce.Obuca;

import com.example.ProdavnicaObuce.Prodavnica.ProdavnicaEntity;
import com.example.ProdavnicaObuce.Proizvodjac.ProizvodjacEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ObucaRepository extends JpaRepository<ObucaEntity, Integer> {
   List<ObucaEntity> pretragaPoObuciGrupiIKorisniku(Integer obucaId, Integer korisnikId,
                                                            Integer prodavnicaId);
   List<ObucaEntity> pretragaObuce(String naziv, Integer korisnikId, Integer prodavnicaId);
   List<ObucaEntity> provjeraUsera(String username, String password);
   List<ObucaEntity> pretraga(DocumentSearchParam searchParam);
   List<IspisProjection> provjeraAdmin();
   List<ProdavnicaProizvodjacProjection> getProdavnicaProizvodjac(String naziv);
   List<ProizvodjacUser> getUserProizvodjac(String naziv);
   List<ObucaEntity> pretragaObuceParametri(SearhObuca searchParam);
   List<IspisProjection> gradCijena();
   List<PretragaObuceProjection> pretragaObuceVelicina(String naziv, Integer velicina);
   List<ProjectionForAllEntities> pretragaPoSvemu(SearchByAll searchParam);

//    List<ObucaEntity> searchObucaByIdsIn(List<Integer> prodavnicaIds);
}
