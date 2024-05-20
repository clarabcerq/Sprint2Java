package br.com.fiap.dtos;

import java.sql.Timestamp;

import br.com.fiap.model.Pergunta;
import lombok.Builder;

@Builder
public record RespostaDto(
		int idResposta,
		String conteudoResposta,
		Timestamp dataHoraResposta,
		Pergunta pergunta) {

}
