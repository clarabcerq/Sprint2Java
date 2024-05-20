package br.com.fiap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.dtos.SessaoLoginDto;
import br.com.fiap.model.SessaoLogin;
import br.com.fiap.service.SessaoLoginService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping(value = "/sessaoLogin")
public class SessaoLoginController {

	private SessaoLoginService sessaoLoginService;
	
	public SessaoLoginController(SessaoLoginService sessaoLoginService) {
		this.sessaoLoginService = sessaoLoginService;
	}
	
	@GetMapping("/{idSessao}")
	public SessaoLogin buscarSessao(@PathVariable int idSessao) {
		return sessaoLoginService.buscarSessao(idSessao);
	}
	
	@PostMapping
	@Transactional
	public SessaoLogin criarSessao(@RequestBody SessaoLoginDto sessaoLoginDto) {
		return sessaoLoginService.criarSessao(sessaoLoginDto);
	}
}
