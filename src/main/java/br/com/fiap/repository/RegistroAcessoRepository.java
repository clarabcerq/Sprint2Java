package br.com.fiap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.model.RegistroAcesso;

@Repository
public interface RegistroAcessoRepository extends JpaRepository<RegistroAcesso, Integer>{

	RegistroAcesso findByIdAcesso(int idAcesso);
}
