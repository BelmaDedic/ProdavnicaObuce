package com.example.ProdavnicaObuce.ProizvodjacSponzor;

import com.example.ProdavnicaObuce.Obuca.ObucaEntity;
import com.example.ProdavnicaObuce.Prodavnica.ProdavnicaEntity;
import com.example.ProdavnicaObuce.User.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProizvodjacSponzorRepositoryImpl {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void deleteProizvodjacSponzor(Integer proizvodjacId, Integer sponzorId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaDelete<ProizvodjacSponzorEntity> delete = criteriaBuilder
                .createCriteriaDelete(ProizvodjacSponzorEntity.class);
        Root<ProizvodjacSponzorEntity> root = delete.from(ProizvodjacSponzorEntity.class);

        List<Predicate> predicates = new ArrayList<Predicate>();
        predicates.add(criteriaBuilder.equal(root.get("proizvodjac"), proizvodjacId));
        predicates.add(criteriaBuilder.equal(root.get("sponzor"), sponzorId));

        delete.where(predicates.toArray(new Predicate[predicates.size()]));
        entityManager.createQuery(delete).executeUpdate();
    }

    @Transactional
    public void updateProizvodjacSponzor(Integer proizvodjacId, Integer sponzorId,
                                         Integer noviProizvodjacId, Integer noviSponzorId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<ProizvodjacSponzorEntity> update = criteriaBuilder
                .createCriteriaUpdate(ProizvodjacSponzorEntity.class);
        Root<ProizvodjacSponzorEntity> root = update.from(ProizvodjacSponzorEntity.class);

        List<Predicate> predicates = new ArrayList<Predicate>();
        predicates.add(criteriaBuilder.equal(root.get("proizvodjac"), proizvodjacId));
        predicates.add(criteriaBuilder.equal(root.get("sponzor"), sponzorId));

        update.set("proizvodjac", noviProizvodjacId);
        update.set("sponzor", noviSponzorId);
        update.where(predicates.toArray(new Predicate[predicates.size()]));
        entityManager.createQuery(update).executeUpdate();
    }
}
