package com.example.jokenpo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jokenpo.model.Jogada;

@Repository
public interface JogadaRepository extends JpaRepository<Jogada, Long>{

}
