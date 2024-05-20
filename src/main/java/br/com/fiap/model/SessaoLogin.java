package br.com.fiap.model;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sessao_login")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SessaoLogin implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_sessao_login")
	@SequenceGenerator(name = "seq_sessao_login", sequenceName = "seq_sessao_login", allocationSize = 1)
	@Column(name = "id_sess")
	private int idSessao;
	
	@Column(name = "email_login")
	private String emailLogin;
	
	@Column(name = "data_hora_login")
	private Timestamp dataHoraLogin;
	
	@Column(name = "data_hora_logout")
	private Timestamp dataHoraLogout;
	
	@Column(name = "senha_login")
	private String senhaLogin;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cadastro_id_cadastro")
	private Cadastro cadastro;
	
}
