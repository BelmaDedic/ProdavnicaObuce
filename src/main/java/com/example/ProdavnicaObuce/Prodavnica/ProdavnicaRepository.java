package com.example.ProdavnicaObuce.Prodavnica;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdavnicaRepository extends JpaRepository<ProdavnicaEntity, Integer> {
//    List<ProdavnicaEntity> findByIds(List<Integer> gradIds);
}
