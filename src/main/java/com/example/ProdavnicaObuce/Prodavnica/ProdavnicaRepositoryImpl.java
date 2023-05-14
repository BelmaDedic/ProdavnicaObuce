package com.example.ProdavnicaObuce.Prodavnica;

import com.example.ProdavnicaObuce.Obuca.ObucaEntity;
import com.example.ProdavnicaObuce.Obuca.ProjectionForAllEntities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProdavnicaRepositoryImpl {
    @Autowired
    private EntityManager entityManager;

//    public List<ProdavnicaEntity> findByIds(List<Integer> gradIds) {
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<ProdavnicaEntity> criteriaQuery =
//                criteriaBuilder.createQuery(ProdavnicaEntity.class);
//        Root<ProdavnicaEntity> root = criteriaQuery.from(ProdavnicaEntity.class);
//
//        Predicate predicate = root.get("grad").in(gradIds);
//
//        criteriaQuery.where(predicate);
//        return entityManager.createQuery(criteriaQuery).getResultList();
//    }
}
