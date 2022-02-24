package com.example.jokenpo.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Rodada {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long rodada;
	
	@ManyToOne
	private Jogador jogador;
	
	@ManyToOne
	private Jogada jogada;
	
	private Long idJogador;
	private Long idJogada;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRodada() {
		return rodada;
	}
	public void setRodada(Long rodada) {
		this.rodada = rodada;
	}
	public Jogador getJogador() {
		return jogador;
	}
	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
	public Jogada getJogada() {
		return jogada;
	}
	public void setJogada(Jogada jogada) {
		this.jogada = jogada;
	}
	public Long getIdJogador() {
		return idJogador;
	}
	public void setIdJogador(Long idJogador) {
		this.idJogador = idJogador;
	}
	public Long getIdJogada() {
		return idJogada;
	}
	public void setIdJogada(Long idJogada) {
		this.idJogada = idJogada;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, idJogada, idJogador, jogada, jogador, rodada);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rodada other = (Rodada) obj;
		return Objects.equals(id, other.id) && Objects.equals(idJogada, other.idJogada)
				&& Objects.equals(idJogador, other.idJogador) && Objects.equals(jogada, other.jogada)
				&& Objects.equals(jogador, other.jogador) && Objects.equals(rodada, other.rodada);
	}

	
}
