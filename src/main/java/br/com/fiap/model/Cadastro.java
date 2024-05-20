package br.com.fiap.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cadastro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cadastro implements Serializable{

	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "seq_cadastro")
	@SequenceGenerator(
			name = "seq_cadastro", 
			sequenceName = "seq_cadastro",
			allocationSize = 1)
	//@Column(name = "id_cadastro")
	private int idCadastro;
	
	@Column(name = "nome_user")
	private String nomeUser;
	
	@Column(name = "email_user")
	private String emailUser;
	
	@Column(name = "senha_user")
	private String senhaUser;
	
	@Column(name = "cpf")
	private long cpf;
	
}
