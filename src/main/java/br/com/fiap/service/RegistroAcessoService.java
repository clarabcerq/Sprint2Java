package br.com.fiap.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.fiap.dtos.RegistroAcessoDto;
import br.com.fiap.model.RegistroAcesso;
import br.com.fiap.model.SessaoLogin;
import br.com.fiap.repository.RegistroAcessoRepository;

@Service
public class RegistroAcessoService {

	private RegistroAcessoRepository registroAcessoRepository;
	private SessaoLoginService sessaoLoginService;

	public RegistroAcessoService(RegistroAcessoRepository registroAcessoRepository, SessaoLoginService sessaoLoginService) {
		this.registroAcessoRepository = registroAcessoRepository;
		this.sessaoLoginService = sessaoLoginService;
	}

	// Consultar acesso pelo id
	public RegistroAcesso buscarRegistro(int idAcesso) {
		Optional<RegistroAcesso> registro = registroAcessoRepository.findById(idAcesso);
		return registro.get();
	}

	// Criar registro
	public RegistroAcesso criarRegistro(RegistroAcessoDto registroAcessoDto) {
		SessaoLogin sessaoLogin = sessaoLoginService.buscarSessao(registroAcessoDto.sessaoLogin().getIdSessao());
		
		RegistroAcesso registroAcesso = new RegistroAcesso();
		registroAcesso.setSessaoLogin(sessaoLogin);
		registroAcesso.setIdAcesso(registroAcessoDto.idAcesso());
		registroAcesso.setTipoAcesso(registroAcessoDto.tipoAcesso());
		registroAcesso.setDataHoraAcesso(registroAcessoDto.dataHoraAcesso());

		return registroAcessoRepository.save(registroAcesso);
	}

	// Atualizar registro
	public RegistroAcesso atualizarRegistro(RegistroAcessoDto registroAcessoDto, int idAcesso) {
		RegistroAcesso registroAcesso = registroAcessoRepository.findById(idAcesso).get();
		registroAcesso.setTipoAcesso(registroAcessoDto.tipoAcesso());
		registroAcesso.setDataHoraAcesso(registroAcessoDto.dataHoraAcesso());
		return registroAcessoRepository.save(registroAcesso);
	}

	// Deletar registro
	public void deletarRegistro(int idAcesso) {
		RegistroAcesso registroAcesso = registroAcessoRepository.findByIdAcesso(idAcesso);
		registroAcessoRepository.delete(registroAcesso);
	}
}
