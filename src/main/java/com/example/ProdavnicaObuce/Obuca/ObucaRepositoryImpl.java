package com.example.ProdavnicaObuce.Obuca;

import com.example.ProdavnicaObuce.Drzava.DrzavaEntity;
import com.example.ProdavnicaObuce.Grad.GradEntity;
import com.example.ProdavnicaObuce.Prodavnica.ProdavnicaEntity;
import com.example.ProdavnicaObuce.Proizvodjac.ProizvodjacEntity;
import com.example.ProdavnicaObuce.User.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ObucaRepositoryImpl {
    @Autowired
    private EntityManager entityManager;

    public List<ObucaEntity> pretragaPoObuciGrupiIKorisniku(Integer obucaId, Integer korisnikId,
                                                   Integer prodavnicaId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ObucaEntity> criteriaQuery = criteriaBuilder.createQuery(ObucaEntity.class);
        Root<ObucaEntity> root = criteriaQuery.from(ObucaEntity.class);

        Join<ObucaEntity, UserEntity> obucaUser = root.join("user", JoinType.LEFT);
        Join<ObucaEntity, ProdavnicaEntity> obucaProdavnica = root.join("prodavnica", JoinType.LEFT);

        List<Predicate> predicates = new ArrayList<Predicate>();
        predicates.add(criteriaBuilder.equal(obucaUser.get("id"), korisnikId));
        predicates.add(criteriaBuilder.equal(root.get("id"), obucaId));
        predicates.add(criteriaBuilder.equal(obucaProdavnica.get("id"), prodavnicaId));

        criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public List<ObucaEntity> pretragaObuce(String naziv, Integer korisnikId, Integer prodavnicaId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ObucaEntity> criteriaQuery = criteriaBuilder.createQuery(ObucaEntity.class);
        Root<ObucaEntity> root = criteriaQuery.from(ObucaEntity.class);

        Join<ObucaEntity, UserEntity> obucaUser = root.join("user", JoinType.LEFT);
        Join<ObucaEntity, ProdavnicaEntity> obucaProdavnica = root.join("prodavnica", JoinType.LEFT);

        List<Predicate> predicates = new ArrayList<Predicate>();
        predicates.add(criteriaBuilder.equal(obucaUser.get("id"), korisnikId));
        predicates.add(criteriaBuilder.equal(root.get("naziv"), naziv));
        predicates.add(criteriaBuilder.equal(obucaProdavnica.get("id"), prodavnicaId));

        criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public List<ObucaEntity> provjeraUsera(String username, String password) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ObucaEntity> criteriaQuery = criteriaBuilder.createQuery(ObucaEntity.class);
        Root<ObucaEntity> root = criteriaQuery.from(ObucaEntity.class);

        List<Predicate> predicates = new ArrayList<Predicate>();
        predicates.add(criteriaBuilder.equal(root.join("user").get("username"), username));
        predicates.add(criteriaBuilder.equal(root.join("user").get("password"), password));

        criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }


    public List<ObucaEntity> pretraga(DocumentSearchParam searchParam) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ObucaEntity> criteriaQuery = criteriaBuilder.createQuery(ObucaEntity.class);
        Root<ObucaEntity> root = criteriaQuery.from(ObucaEntity.class);

        Join<ObucaEntity, UserEntity> obucaUser = root.join("user");
        Join<ObucaEntity, ProdavnicaEntity> obucaProdavnica = root.join("prodavnica");

        List<Predicate> predicates = new ArrayList<Predicate>();

        if(searchParam.getBoja() != null) {
            predicates.add(criteriaBuilder.equal(root.get("boja"), searchParam.getBoja()));
        }
        if(searchParam.getImeUser() != null) {
            predicates.add(criteriaBuilder.equal(obucaUser.get("ime"), searchParam.getImeUser()));
        }
        if(searchParam.getNazivProdavnica() != null) {
            predicates.add(criteriaBuilder.equal(obucaProdavnica.get("naziv"),
                    searchParam.getNazivProdavnica()));
        }
        if(searchParam.getBoja() == null && searchParam.getImeUser() == null &&
                searchParam.getNazivProdavnica() == null) {
            throw new NullPointerException();
        }

        criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public List<IspisProjection> provjeraAdmin() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<IspisProjection> criteriaQuery = criteriaBuilder.createQuery(IspisProjection.class);
        Root<ObucaEntity> root = criteriaQuery.from(ObucaEntity.class);

        List<Predicate> predicates = new ArrayList<Predicate>();
        criteriaQuery.multiselect(root.get("user").get("ime"), criteriaBuilder.sum(root.get("cijena")),
                root.get("prodavnica").get("grad").get("naziv")).distinct(true);
        criteriaQuery.groupBy(root.get("user").get("ime"), root.get("prodavnica").get("grad").get("naziv"));
        criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public List<ProdavnicaProizvodjacProjection> getProdavnicaProizvodjac(String naziv) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProdavnicaProizvodjacProjection> criteriaQuery =
                criteriaBuilder.createQuery(ProdavnicaProizvodjacProjection.class);
        Root<ObucaEntity> root = criteriaQuery.from(ObucaEntity.class);

        Join<ObucaEntity, ProizvodjacEntity> obucaProizvodjac = root.join("proizvodjac");
        Join<ObucaEntity, ProdavnicaEntity> obucaProdavnica = root.join("prodavnica");

        List<Predicate> predicates = new ArrayList<Predicate>();
        predicates.add(criteriaBuilder.equal(obucaProizvodjac.get("naziv"), naziv));
        criteriaQuery.multiselect(obucaProdavnica.get("id"), obucaProdavnica.get("naziv"),
                obucaProdavnica.get("grad").get("naziv"), obucaProdavnica.get("adresa"));

        criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public List<ProizvodjacUser> getUserProizvodjac(String naziv) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProizvodjacUser> criteriaQuery =
                criteriaBuilder.createQuery(ProizvodjacUser.class);
        Root<ObucaEntity> root = criteriaQuery.from(ObucaEntity.class);

        Join<ObucaEntity, ProizvodjacEntity> obucaProizvodjac = root.join("proizvodjac");
        Join<ObucaEntity, ProdavnicaEntity> obucaProdavnica = root.join("prodavnica");
        Join<ObucaEntity, UserEntity> obucaUser = root.join("user");

        List<Predicate> predicates = new ArrayList<Predicate>();
        predicates.add(criteriaBuilder.equal(obucaProizvodjac.get("naziv"), naziv));
        criteriaQuery.multiselect(obucaUser.get("id"), obucaUser.get("ime"), obucaUser.get("prezime"),
                obucaUser.get("email"), obucaProdavnica.get("grad").get("naziv"));

        criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public List<ObucaEntity> pretragaObuceParametri(SearhObuca searchParam) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ObucaEntity> criteriaQuery = criteriaBuilder.createQuery(ObucaEntity.class);
        Root<ObucaEntity> root = criteriaQuery.from(ObucaEntity.class);

        Join<ObucaEntity, UserEntity> obucaUser = root.join("user");
        Join<ObucaEntity, ProdavnicaEntity> obucaProdavnica = root.join("prodavnica");
        Join<ObucaEntity, ProizvodjacEntity> obucaProizvodjac = root.join("proizvodjac");

        List<Predicate> predicates = new ArrayList<Predicate>();

        if(searchParam.getProizvodjac() != null) {
            predicates.add(criteriaBuilder.equal(criteriaBuilder.lower(obucaProizvodjac.get("naziv")),
                    searchParam.getProizvodjac().toLowerCase()));
        }
        if(searchParam.getGrad() != null) {
            predicates.add(criteriaBuilder.equal(criteriaBuilder.lower(obucaProdavnica.get("grad")
                    .get("naziv")), searchParam.getGrad().toLowerCase()));
        }
        if(searchParam.getNazivObuce() != null) {
            predicates.add(criteriaBuilder.equal(criteriaBuilder.lower(root.get("naziv")),
                    searchParam.getNazivObuce().toLowerCase()));
        }
        if(searchParam.getUsername() != null) {
            predicates.add(criteriaBuilder.equal(criteriaBuilder.lower(obucaUser.get("username")),
                    searchParam.getUsername().toLowerCase()));
        }

        criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public List<IspisProjection> gradCijena() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<IspisProjection> criteriaQuery = criteriaBuilder.createQuery(IspisProjection.class);
        Root<ObucaEntity> root = criteriaQuery.from(ObucaEntity.class);

        List<Predicate> predicates = new ArrayList<Predicate>();
        criteriaQuery.multiselect(criteriaBuilder.sum(root.get("cijena")),
                root.get("prodavnica").get("grad").get("naziv")).distinct(true);
        criteriaQuery.groupBy(root.get("prodavnica").get("grad").get("naziv"));
        criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public List<PretragaObuceProjection> pretragaObuceVelicina(String naziv, Integer velicina) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PretragaObuceProjection> criteriaQuery = criteriaBuilder
                .createQuery(PretragaObuceProjection.class);
        Root<ObucaEntity> root = criteriaQuery.from(ObucaEntity.class);

        List<Predicate> predicates = new ArrayList<Predicate>();
        predicates.add(criteriaBuilder.equal(root.get("naziv"), naziv));
        predicates.add(criteriaBuilder.equal(root.get("velicina"), velicina));

        criteriaQuery.multiselect(root.get("naziv"), root.get("prodavnica").get("grad").get("naziv"),
                criteriaBuilder.selectCase()
                        .when(criteriaBuilder.isNotNull(root.get("user")), true)
                        .otherwise(false), root.get("velicina"));
        criteriaQuery.groupBy(root.get("naziv"), root.get("prodavnica").get("grad").get("naziv"),
                root.get("user"), root.get("velicina"));
        criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

//    List<ObucaEntity> searchObucaByIdsIn(List<Integer> prodavnicaIds) {
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<ObucaEntity> criteriaQuery =
//                criteriaBuilder.createQuery(ObucaEntity.class);
//        Root<ObucaEntity> root = criteriaQuery.from(ObucaEntity.class);
//
//        List<Predicate> predicates = new ArrayList<Predicate>();
//        predicates.add(root.get("prodavnica").get("id").in(prodavnicaIds));
//
//        criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));
//        return entityManager.createQuery(criteriaQuery).getResultList();
//    }

    public List<ProjectionForAllEntities> pretragaPoSvemu(SearchByAll searchParam) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProjectionForAllEntities> criteriaQuery =
                criteriaBuilder.createQuery(ProjectionForAllEntities.class);
        Root<ObucaEntity> root = criteriaQuery.from(ObucaEntity.class);

        Join<ObucaEntity, UserEntity> obucaUser = root.join("user");
        Join<ObucaEntity, ProdavnicaEntity> obucaProdavnica = root.join("prodavnica");
        Join<ObucaEntity, ProizvodjacEntity> obucaProizvodjac = root.join("proizvodjac");
        Join<ProdavnicaEntity, GradEntity> prodavnicaGrad = obucaProdavnica.join("grad");
        Join<GradEntity, DrzavaEntity> gradDrzava= prodavnicaGrad.join("drzava");

        List<Predicate> predicates = new ArrayList<Predicate>();

        if(searchParam.getNazivObuca() != null) {
            predicates.add(criteriaBuilder.equal(criteriaBuilder.lower(root.get("naziv")),
                    searchParam.getNazivObuca().toLowerCase()));
        }
        if(searchParam.getImeUser() != null) {
            predicates.add(criteriaBuilder.equal(criteriaBuilder.lower(obucaUser.get("ime")),
                    searchParam.getImeUser().toLowerCase()));
        }
        if(searchParam.getProizvodjac() != null) {
            predicates.add(criteriaBuilder.equal(criteriaBuilder.lower(obucaProizvodjac.get("naziv")),
                    searchParam.getProizvodjac().toLowerCase()));
        }
        if(searchParam.getNazivProdavnice() != null) {
            predicates.add(criteriaBuilder.equal(criteriaBuilder.lower(obucaProdavnica.get("naziv")),
                    searchParam.getNazivProdavnice().toLowerCase()));
        }
        if(searchParam.getNazivGrada() != null) {
            predicates.add(criteriaBuilder.equal(criteriaBuilder.lower(prodavnicaGrad.get("naziv")),
                    searchParam.getNazivGrada().toLowerCase()));
        }
        if(searchParam.getNazivDrzave() != null) {
            predicates.add(criteriaBuilder.equal(criteriaBuilder.lower(gradDrzava.get("naziv")),
                    searchParam.getNazivDrzave().toLowerCase()));
        }


        criteriaQuery.multiselect(root.get("naziv"), root.get("boja"), obucaUser.get("ime"),
                obucaUser.get("username"), obucaProizvodjac.get("naziv"), obucaProizvodjac.get("sjediste"),
                obucaProdavnica.get("naziv"), obucaProdavnica.get("adresa"), prodavnicaGrad.get("naziv"),
                prodavnicaGrad.get("postanskiBroj"), gradDrzava.get("naziv"), gradDrzava.get("valuta"));
        criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}