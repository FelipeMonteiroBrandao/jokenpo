package com.example.jokenpo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jokenpo.model.Rodada;

@Repository
public interface RodadaRepository extends JpaRepository<Rodada, Long>{

}
