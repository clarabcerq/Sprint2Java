package br.com.fiap.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.dtos.RespostaDto;
import br.com.fiap.model.Resposta;
import br.com.fiap.service.RespostaService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping(value = "/resposta")
public class RespostaController {

	private RespostaService respostaService;

	public RespostaController(RespostaService respostaService) {
		this.respostaService = respostaService;
	}
	
	@GetMapping("/{idResposta}")
	public Resposta buscarResposta(@PathVariable int idResposta) {
		return respostaService.buscarResposta(idResposta);
	}
	
	@PostMapping
	@Transactional
	public Resposta criarResposta(@RequestBody RespostaDto respostaDto) {
		return respostaService.criarResposta(respostaDto);
	}
	
	@PutMapping("/{idResposta}")
	@Transactional
	public String atualizarResposta(@RequestBody RespostaDto respostaDto, @PathVariable int idResposta) {
		respostaService.atualizarResposta(respostaDto, idResposta);
		return "Resposta atualizada";
	}
	
	@DeleteMapping("/{idResposta}")
	public String deletarResposta(@PathVariable int idResposta) {
		respostaService.deletarResposta(idResposta);
		return "Resposta deletada";
	}
}
