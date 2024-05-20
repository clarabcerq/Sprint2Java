package br.com.fiap.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.dtos.CadastroDto;
import br.com.fiap.model.Cadastro;
import br.com.fiap.service.CadastroService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {

	private CadastroService cadastroService;

	public CadastroController(CadastroService cadastroService) {
		this.cadastroService = cadastroService;
	}

	@GetMapping("/{idCadastro}")
	public Cadastro buscarCadastro(@PathVariable int idCadastro) {
		return cadastroService.buscarCadastro(idCadastro);
	}

	@PostMapping
	@Transactional
	public Cadastro criarCadastro(@RequestBody CadastroDto cadastroDto) {
		return cadastroService.criarCadastro(cadastroDto);
	}

	@PutMapping("/{idCadastro}")
	@Transactional
	public Cadastro atualizarCadastro(@RequestBody CadastroDto cadastroDto, @PathVariable int idCadastro) {
		return cadastroService.atualizarCadastro(cadastroDto, idCadastro);
	}

	@DeleteMapping("/{idCadastro}")
	public String deletarCadastro(@PathVariable int idCadastro) {
		cadastroService.deletarCadastro(idCadastro);
		return "Cadastro deletado";
	}
}
