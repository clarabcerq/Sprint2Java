package br.com.fiap.dtos;

import java.sql.Timestamp;

import br.com.fiap.model.SessaoLogin;
import lombok.Builder;

@Builder
public record RegistroAcessoDto(
		int idAcesso,
		String tipoAcesso,
		Timestamp dataHoraAcesso,
		SessaoLogin sessaoLogin) {

}
