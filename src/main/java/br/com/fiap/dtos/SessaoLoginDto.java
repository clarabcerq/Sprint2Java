package br.com.fiap.dtos;

import java.sql.Timestamp;

import br.com.fiap.model.Cadastro;
import lombok.Builder;

@Builder
public record SessaoLoginDto(
		int idSessao,
		String emailLogin,
		Timestamp dataHoraLogin,
		Timestamp dataHoraLogout,
		String senhaLogin,
		Cadastro cadastro) {

}
