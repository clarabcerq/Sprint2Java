package br.com.fiap.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.fiap.dtos.PerguntaDto;
import br.com.fiap.model.Cadastro;
import br.com.fiap.model.Pergunta;
import br.com.fiap.repository.PerguntaRepository;

@Service
public class PerguntaService {

	private PerguntaRepository perguntaRepository;
	private CadastroService cadastroService;

	public PerguntaService(PerguntaRepository perguntaRepository, CadastroService cadastroService) {
		this.perguntaRepository = perguntaRepository;
		this.cadastroService = cadastroService;
	}

	// Buscar pergunta pelo id
	public Pergunta buscarPergunta(int idPergunta) {
		Optional<Pergunta> pergunta = perguntaRepository.findById(idPergunta);
		return pergunta.get();
	}

	// Criar pergunta
	public Pergunta criarPergunta(PerguntaDto perguntaDto) {
		Cadastro cadastro = cadastroService.buscarCadastro(perguntaDto.cadastro().getIdCadastro());
		
		Pergunta pergunta = new Pergunta();
		pergunta.setCadastro(cadastro);
		pergunta.setConteudoPergunta(perguntaDto.conteudoPergunta());
		pergunta.setDataHoraPerg(perguntaDto.dataHoraPerg());
		
		return perguntaRepository.save(pergunta);
	}

	// Atualizar pergunta
	public Pergunta atualizarPergunta(PerguntaDto perguntaDto, int idPergunta) {
		Pergunta pergunta = perguntaRepository.findById(idPergunta).get();
		pergunta.setConteudoPergunta(perguntaDto.conteudoPergunta());
		pergunta.setDataHoraPerg(perguntaDto.dataHoraPerg());
		return perguntaRepository.save(pergunta);
	}

	// Deletar Pergunta
	public void deletarPergunta(int idPergunta) {
		Pergunta pergunta = perguntaRepository.findByIdPergunta(idPergunta);
		perguntaRepository.delete(pergunta);
	}
}
