package br.com.fiap.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.fiap.dtos.CadastroDto;
import br.com.fiap.model.Cadastro;
import br.com.fiap.repository.CadastroRepository;

@Service
public class CadastroService {

	private CadastroRepository cadastroRepository;

	public CadastroService(CadastroRepository cadastroRepository) {
		this.cadastroRepository = cadastroRepository;
	}

	// Buscar cadastro pelo id
	public Cadastro buscarCadastro(int idCadastro) {
		Optional<Cadastro> cadastro = cadastroRepository.findById(idCadastro);
		return cadastro.get();
	}

	// Criar cadastro
	public Cadastro criarCadastro(CadastroDto cadastroDto) {
		Cadastro cadastro = new Cadastro();
		cadastro.setNomeUser(cadastroDto.nomeUser());
		cadastro.setEmailUser(cadastroDto.emailUser());
		cadastro.setSenhaUser(cadastroDto.senhaUser());
		cadastro.setCpf(cadastroDto.cpf());
		return cadastroRepository.save(cadastro);
	}

	// Atualizar cadastro
	public Cadastro atualizarCadastro(CadastroDto cadastroDto, int idCadastro) {
		Cadastro cadastro = cadastroRepository.findById(idCadastro).get();
		cadastro.setNomeUser(cadastroDto.nomeUser());
		cadastro.setEmailUser(cadastroDto.emailUser());
		cadastro.setSenhaUser(cadastroDto.senhaUser());
		cadastro.setCpf(cadastroDto.cpf());
		return cadastroRepository.save(cadastro);
	}

	// Deletar cadastro
	public void deletarCadastro(int idCadastro) {
		Cadastro cadastro = cadastroRepository.findByIdCadastro(idCadastro);
		cadastroRepository.delete(cadastro);
	}

}
