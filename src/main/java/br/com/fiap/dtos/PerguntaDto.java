package br.com.fiap.dtos;

import java.sql.Timestamp;

import br.com.fiap.model.Cadastro;
import lombok.Builder;

@Builder
public record PerguntaDto(
		int idPergunta,
		String conteudoPergunta,
		Timestamp dataHoraPerg,
		Cadastro cadastro) {

}
