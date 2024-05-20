package br.com.fiap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.model.Pergunta;

@Repository
public interface PerguntaRepository extends JpaRepository<Pergunta, Integer>{

	Pergunta findByIdPergunta(int idPergunta);
}
