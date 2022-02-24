package com.example.jokenpo.jogadorController;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.jokenpo.controller.JogadorController;
import com.example.jokenpo.model.Jogador;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class JogadorControllerTest {
	
	@Autowired
	private JogadorController jogadorController;
	
	@Test
	public void adicionarJogadorTest() {
		
		Jogador request = publicaJogador();
		
		Jogador jogador = jogadorController.adicionar(request);
		assertEquals("1", String.valueOf(jogador.getId()));
		assertEquals("Felipe", jogador.getNome());
	}
	
	@Test
	public void excluirJogadorTest() {
		
		Jogador request = publicaJogador();
		
		jogadorController.adicionar(request);
		
		String result = jogadorController.deletar(1L);
		assertEquals("Jogador excluido com sucesso!", result);
	}
	
	@Test
	public void listarJogadorTest() {
		
		Jogador request = publicaJogador();
		
		request = jogadorController.adicionar(request);
		
		List<Jogador> jogador = jogadorController.listar();
		assertEquals("1", String.valueOf(jogador.get(0).getId()));
		assertEquals("Felipe", jogador.get(0).getNome());
	}
	
	public Jogador publicaJogador() {
		
		Jogador jogador = new Jogador();
		jogador.setId(1L);
		jogador.setNome("Felipe");
		
		return jogador;
	}

}
