package br.com.fiap.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.dtos.RegistroAcessoDto;
import br.com.fiap.model.RegistroAcesso;
import br.com.fiap.service.RegistroAcessoService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping(value = "/registroAcesso")
public class RegistroAcessoController {

	private RegistroAcessoService registroAcessoService;

	public RegistroAcessoController(RegistroAcessoService registroAcessoService) {
		this.registroAcessoService = registroAcessoService;
	}

	@GetMapping("/{idAcesso}")
	public RegistroAcesso buscarRegistro(@PathVariable int idAcesso) {
		return registroAcessoService.buscarRegistro(idAcesso);
	}

	@PostMapping
	@Transactional
	public RegistroAcesso criarRegistro(@RequestBody RegistroAcessoDto registroAcessoDto) {
		return registroAcessoService.criarRegistro(registroAcessoDto);
	}

	@PutMapping("/{idAcesso}")
	@Transactional
	public RegistroAcesso atualizarRegistro(@RequestBody RegistroAcessoDto registroAcessoDto, @PathVariable int idAcesso) {
		return registroAcessoService.atualizarRegistro(registroAcessoDto, idAcesso);
	}

	@DeleteMapping("/{idAcesso}")
	public String deletarRegistro(@PathVariable int idAcesso) {
		registroAcessoService.deletarRegistro(idAcesso);
		return "Registro deletado";
	}
}
