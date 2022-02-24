package com.example.jokenpo.jogadorController;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.jokenpo.controller.JogadaController;
import com.example.jokenpo.model.Jogada;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class JogadaControllerTeste {
	
	@Autowired
	private JogadaController jogadaController;
	
	@Test
	public void adicionarJogadaTest() {
		
		Jogada request = publicaJogada();
		
		Jogada jogada = jogadaController.adicionar(request);
		assertEquals("1", String.valueOf(jogada.getId()));
		assertEquals("Pedra", jogada.getNome());
	}
	
	@Test
	public void excluirJogadaTest() {
		
		Jogada request = publicaJogada();
		
		jogadaController.adicionar(request);
		
		String result = jogadaController.deletar(1L);
		assertEquals("Jogada excluida com sucesso!", result);
	}
	
	@Test
	public void listarJogadaTest() {
		
		Jogada request = publicaJogada();
		
		jogadaController.adicionar(request);
		
		List<Jogada> jogada = jogadaController.listar();
		assertEquals("1", String.valueOf(jogada.get(0).getId()));
		assertEquals("Pedra", jogada.get(0).getNome());
	}
	
	public Jogada publicaJogada() {
		
		Jogada jogada = new Jogada();
		jogada.setId(1L);
		jogada.setNome("Pedra");
		
		return jogada;
	}

}
