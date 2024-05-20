package br.com.fiap.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.dtos.PerguntaDto;
import br.com.fiap.model.Pergunta;
import br.com.fiap.service.PerguntaService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping(value = "/pergunta")
public class PerguntaController {

	private PerguntaService perguntaService;

	public PerguntaController(PerguntaService perguntaService) {
		this.perguntaService = perguntaService;
	}

	@GetMapping("/{idPergunta}")
	public Pergunta buscarPergunta(@PathVariable int idPergunta) {
		return perguntaService.buscarPergunta(idPergunta);
	}

	@PostMapping
	@Transactional
	public Pergunta criarPergunta(@RequestBody PerguntaDto perguntaDto) {
		return perguntaService.criarPergunta(perguntaDto);
	}

	@PutMapping("/{idPergunta}")
	@Transactional
	public Pergunta atualizarPergunta(@RequestBody PerguntaDto perguntaDto, @PathVariable int idPergunta) {
		return perguntaService.atualizarPergunta(perguntaDto, idPergunta);
	}

	@DeleteMapping("/{idPergunta}")
	public void deletarPergunta(@PathVariable int idPergunta) {
		perguntaService.deletarPergunta(idPergunta);
	}
}
