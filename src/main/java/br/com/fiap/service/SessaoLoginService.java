package br.com.fiap.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.fiap.dtos.SessaoLoginDto;
import br.com.fiap.model.Cadastro;
import br.com.fiap.model.SessaoLogin;
import br.com.fiap.repository.SessaoLoginRepository;

@Service
public class SessaoLoginService {

	private SessaoLoginRepository sessaoLoginRepository;
	private CadastroService cadastroService;

	public SessaoLoginService(SessaoLoginRepository sessaoLoginRepository, CadastroService cadastroService) {
		this.sessaoLoginRepository = sessaoLoginRepository;
		this.cadastroService = cadastroService;
	}

	// Buscar sessão pelo id
	public SessaoLogin buscarSessao(int idSessao) {
		Optional<SessaoLogin> sessaoLogin = sessaoLoginRepository.findById(idSessao);
		return sessaoLogin.get();
	}

	// Criar sessao - não existirão métodos atualizar e deletar pois a sessão não se atualiza ou é excluída
	public SessaoLogin criarSessao(SessaoLoginDto sessaoLoginDto) {
		Cadastro cadastro = cadastroService.buscarCadastro(sessaoLoginDto.cadastro().getIdCadastro());
		
		SessaoLogin sessaoLogin = new SessaoLogin();
		sessaoLogin.setCadastro(cadastro);
		sessaoLogin.setEmailLogin(sessaoLoginDto.emailLogin());
		sessaoLogin.setDataHoraLogin(sessaoLoginDto.dataHoraLogin());
		sessaoLogin.setDataHoraLogout(sessaoLoginDto.dataHoraLogout());
		sessaoLogin.setSenhaLogin(sessaoLoginDto.senhaLogin());
		
		return sessaoLoginRepository.save(sessaoLogin);
	}
}
