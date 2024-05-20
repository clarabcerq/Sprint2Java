package br.com.fiap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.model.Resposta;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, Integer>{

	Resposta findByIdResposta(int idResposta);
}
