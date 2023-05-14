package com.example.ProdavnicaObuce.ProizvodjacSponzor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProizvodjacSponzorRepository extends JpaRepository<ProizvodjacSponzorEntity, ProizvodjacSponzor>
{
  void deleteProizvodjacSponzor(Integer proizvodjacId, Integer sponzorId);
  void updateProizvodjacSponzor(Integer proizvodjacId, Integer sponzorId,
                                Integer noviProizvodjacId, Integer noviSponzorId);
}
