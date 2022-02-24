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

import com.example.jokenpo.model.Jogada;
import com.example.jokenpo.repository.JogadaRepository;

@RestController
public class JogadaController {
	
	@Autowired
	private JogadaRepository jogadaRepository;
	
	@GetMapping("jogadasListar")
	public List<Jogada> listar() {
		
		return jogadaRepository.findAll();
	}
	
	@PostMapping("jogadasInserir")
	@ResponseStatus(HttpStatus.CREATED)
	public Jogada adicionar(@RequestBody Jogada jogada) {
		return jogadaRepository.save(jogada);
	}
	
	@DeleteMapping("jogadasExcluir/{id}")
	public String deletar(@PathVariable Long id) {
		
		String result = "";
		
		try {
			
			jogadaRepository.deleteById(id);
			
			result = "Jogada excluida com sucesso!";
			
		}catch(Exception ex){
			
			result = "Erro ao excluir jogada: "+ex;
		}
		
		
		return result;
	}

}
