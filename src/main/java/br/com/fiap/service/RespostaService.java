package br.com.fiap.service;

import org.springframework.stereotype.Service;

import br.com.fiap.dtos.RespostaDto;
import br.com.fiap.model.Pergunta;
import br.com.fiap.model.Resposta;
import br.com.fiap.repository.RespostaRepository;

@Service
public class RespostaService {

	private RespostaRepository respostaRepository;
	private PerguntaService perguntaService;

	public RespostaService(RespostaRepository respostaRepository, PerguntaService perguntaService) {
		this.respostaRepository = respostaRepository;
		this.perguntaService = perguntaService;
	}

	// Consultat resposta com id
	public Resposta buscarResposta(int idResposta) {
		return respostaRepository.findByIdResposta(idResposta);
	}

	// Criar resposta
	public Resposta criarResposta(RespostaDto respostaDto) {
		Pergunta pergunta = perguntaService.buscarPergunta(respostaDto.pergunta().getIdPergunta());
		
		Resposta resposta = new Resposta();
		resposta.setPergunta(pergunta);
		resposta.setConteudoResposta(respostaDto.conteudoResposta());
		resposta.setDataHoraResposta(respostaDto.dataHoraResposta());

		/*Pergunta pergunta = new Pergunta();
		pergunta.setIdPergunta(respostaDto.pergunta().getIdPergunta());
		resposta.setPergunta(pergunta);*/
		
		return respostaRepository.save(resposta);
	}

	// Atualizar resposta (para uma nova pergunta na mesma sessão)
	public void atualizarResposta(RespostaDto respostaDto, int idResposta) {
		Resposta resposta = respostaRepository.findById(idResposta).get();
		resposta.setConteudoResposta(respostaDto.conteudoResposta());
		resposta.setDataHoraResposta(respostaDto.dataHoraResposta());
		respostaRepository.save(resposta);
	}

	// Deletar resposta
	public void deletarResposta(int idResposta) {
		Resposta resposta = respostaRepository.findByIdResposta(idResposta);
		respostaRepository.delete(resposta);
	}
}
