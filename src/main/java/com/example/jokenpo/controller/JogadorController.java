package com.example.jokenpo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.jokenpo.model.Jogador;
import com.example.jokenpo.repository.JogadorRepository;

@RestController
public class JogadorController {

	@Autowired
	private JogadorRepository jogadorRepository;
	
	@GetMapping("/jogadoresListar")
	public List<Jogador> listar() {
		
		return jogadorRepository.findAll();
	}
	
	@PostMapping("/jogadoresInserir")
	@ResponseStatus(HttpStatus.CREATED)
	public Jogador adicionar(@RequestBody Jogador jogador) {
		return jogadorRepository.save(jogador);
	}
	
	@DeleteMapping("jogadoresExcluir/{id}")
	public String deletar(@PathVariable Long id) {
		
		String result = "";
		
		try {
			
			jogadorRepository.deleteById(id);
			
			result = "Jogador excluido com sucesso!";
			
		}catch(Exception ex){
			
			result = "Erro ao excluir jogador: "+ex;
		}
		
		return result;
	}
}
