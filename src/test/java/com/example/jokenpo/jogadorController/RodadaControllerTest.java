package com.example.jokenpo.jogadorController;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.jokenpo.controller.JogadaController;
import com.example.jokenpo.controller.JogadorController;
import com.example.jokenpo.controller.RodadaController;
import com.example.jokenpo.model.Jogada;
import com.example.jokenpo.model.Jogador;
import com.example.jokenpo.model.Rodada;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class RodadaControllerTest {
	
	@Autowired
	private RodadaController rodadaController;
	
	@Autowired
	private JogadaController jogadaController;
	
	@Autowired
	private JogadorController jogadorController;
	
	@Test
	public void listarRodadaTest() {
		
		Jogador jogador1 = publicaJogador(1L, "Felipe");
		jogadorController.adicionar(jogador1);
		
		Jogador jogador2 = publicaJogador(2L, "Denise");
		jogadorController.adicionar(jogador2);
		
		Jogador jogador3 = publicaJogador(3L, "José");
		jogadorController.adicionar(jogador3);
		
		Jogada jogada1 = publicaJogada(1L, "Pedra");
		jogadaController.adicionar(jogada1);
		
		Jogada jogada2 = publicaJogada(2L, "Papel");
		jogadaController.adicionar(jogada2);
		
		Jogada jogada3 = publicaJogada(3L, "Tesoura");
		jogadaController.adicionar(jogada3);
		
		Rodada rodada = publicaRodada(1L, 1L, jogador1, jogada1);
		rodadaController.adicionar(rodada);
		
		rodada = publicaRodada(2L, 1L, jogador2, jogada2);
		rodadaController.adicionar(rodada);
		
		rodada = publicaRodada(3L, 1L, jogador3, jogada3);
		rodadaController.adicionar(rodada);
		
		String resultado = rodadaController.listar();
		assertEquals(resultado, "Ganhador --> José jogada: Tesoura");
	}
	
	
	public Jogador publicaJogador(Long id, String nome) {
		
		Jogador jogador = new Jogador();
		jogador.setId(id);
		jogador.setNome(nome);
		
		return jogador;
	}
	
	public Jogada publicaJogada(Long id, String nome) {
		
		Jogada jogada = new Jogada();
		jogada.setId(id);
		jogada.setNome(nome);
		
		return jogada;
	}
	
	public Rodada publicaRodada(Long id, Long Idrodada, Jogador jogador, Jogada jogada) {
		
		Rodada rodada = new Rodada();
		rodada.setId(id);
		rodada.setIdJogador(jogador.getId());
		rodada.setIdJogada(jogada.getId());
		rodada.setRodada(Idrodada);
		rodada.setJogador(jogador);
		rodada.setJogada(jogada);
		
		return rodada;
	}

}


