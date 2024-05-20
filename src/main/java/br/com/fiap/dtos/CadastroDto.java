package br.com.fiap.dtos;

import lombok.Builder;

@Builder
public record CadastroDto(
		int idCadastro,
		String nomeUser,
		String emailUser,
		String senhaUser,
		long cpf) {

}
