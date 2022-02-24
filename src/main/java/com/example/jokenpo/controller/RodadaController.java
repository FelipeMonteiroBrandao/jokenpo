package com.example.jokenpo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.jokenpo.model.Jogada;
import com.example.jokenpo.model.Jogador;
import com.example.jokenpo.model.Rodada;
import com.example.jokenpo.repository.JogadaRepository;
import com.example.jokenpo.repository.JogadorRepository;
import com.example.jokenpo.repository.RodadaRepository;

@RestController
@RequestMapping("/rodada")
public class RodadaController {
			
	@Autowired
	private RodadaRepository rodadaRepository;
	
	@Autowired
	private JogadorRepository jogadorRepository;
	
	@Autowired
	private JogadaRepository jogadaRepository;
	
	public Jogador jogador;
	public Jogada jogada;
	
	@GetMapping
	public String listar() {
		
		List<Rodada> jogadas = rodadaRepository.findAll();
		
		int tam = jogadas.size();
		String resultado = "";
		
		if(tam > 1) {
			
			resultado = validarJogadas(jogadas);
			
		}else {
			
			resultado = "O jogo não pode ser realizado com apenas uma/nenhuma jogada.";
		}
		
		return resultado;
	}
	
	public String validarJogadas(List<Rodada> jogadas) {
		
		String result = "";
		String aux = "";
		String aux2 = "";
		String jogador1, jogador2, jogada1, jogada2;
		
		int j = 1;
		
		if(!(testaEmpate(jogadas) == 1)) {
		
			for (int i = 0; i < jogadas.size(); i++) {
				
				if(j < jogadas.size()) {

					if(aux.equals("")) {
						
						jogador1 = jogadas.get(i).getJogador().getNome();
						jogada1 = jogadas.get(i).getJogada().getNome();
						
						jogador2 = jogadas.get(j).getJogador().getNome();
						jogada2 = jogadas.get(j).getJogada().getNome();
						j++;
						
						System.out.println("                                    "+jogador1 +" : "+jogada1+"                                    ");
						System.out.println("                                    "+jogador2 +" : "+jogada2+"                                    ");
						
						int comparacao = compararJogadas(jogada1, jogada2); 
						
						if(comparacao == 1) {
							aux = jogada1;
							aux2 = jogador1;
						}else if(comparacao == 2){
							aux = jogada2;
							aux2 = jogador2;
						}else if(comparacao == 0) {
							aux2 = "Jogo";
							aux = "Empate";
						}
						
						result = aux2 + " jogada: "+ aux;
						
					}else {
						
						jogador1 = aux2;
						jogada1 = aux;
						
						jogador2 = jogadas.get(j).getJogador().getNome();
						jogada2 = jogadas.get(j).getJogada().getNome();
						j++;
						
						int comparacao = compararJogadas(jogada1, jogada2);
						
						if(comparacao == 1) {
							aux = jogada1;
							aux2 = jogador1;
						}else if(comparacao == 2) {
							aux = jogada2;
							aux2 = jogador2;
						}else if(comparacao == 0) {
							aux2 = "Jogo";
							aux = "Empate";
						}
					
						result = aux2+ " jogada: "+ aux;
					}

				}
				
			}
		
		}else {
			
			result = "Empate!";
		}
		
		return "Ganhador --> "+result;
	}
	
	public int testaEmpate(List<Rodada> jogadas) {
		
		int result = 1;
		int j = 1;
		
		for (int i = 0; i < jogadas.size(); i++) {
			
			if(j < jogadas.size()) {

				String jogada1 = jogadas.get(i).getJogada().getNome();
				String jogada2 = jogadas.get(j).getJogada().getNome();
				j++;
				
				if((jogada1 == jogada2) && (result == 1)) {
					result = 1;
				}else {
					result = 0;
				}

			}
			
		}	
		
		return result;
	}

	public int compararJogadas(String jogada1, String jogada2) {
		
		int result = 0;
		
		if     ((jogada1.equals("Pedra")) && (jogada2.equals("Papel"))) { result = 2;}
		else if((jogada1.equals("Pedra")) && (jogada2.equals("Tesoura"))) { result = 1;}
		else if((jogada1.equals("Pedra")) && (jogada2.equals("Pedra"))) { result = 0;}
		
		if     ((jogada1.equals("Papel")) && (jogada2.equals("Pedra"))) { result = 1;}
		else if((jogada1.equals("Papel")) && (jogada2.equals("Tesoura"))) { result = 2;}
		else if((jogada1.equals("Papel")) && (jogada2.equals("Papel"))) { result = 0;}
		
		if     ((jogada1.equals("Tesoura")) && (jogada2.equals("Pedra"))) { result = 2;}
		else if((jogada1.equals("Tesoura")) && (jogada2.equals("Papel"))) { result = 1;}
		else if((jogada1.equals("Tesoura")) && (jogada2.equals("Tesoura"))) { result = 0;}
		
		return result;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Rodada adicionar(@RequestBody Rodada rodada) {
				
		jogador = jogadorRepository.getById(rodada.getIdJogador());
		jogada = jogadaRepository.getById(rodada.getIdJogada());
		rodada.setJogador(jogador);
		rodada.setJogada(jogada);
		
		return rodadaRepository.save(rodada);
		
	}

}
