package com.example.jokenpo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jokenpo.model.Jogador;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long>{

}
