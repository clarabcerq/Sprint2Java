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
@Table(name = "registro_acesso")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistroAcesso implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_registro_acesso")
	@SequenceGenerator(name = "seq_registro_acesso", sequenceName = "seq_registro_acesso", allocationSize = 1)
	@Column(name = "id_aces")
	private int idAcesso;
	
	@Column(name = "tipo_acesso")
	private String tipoAcesso;
	
	@Column(name = "data_hora_acesso")
	private Timestamp dataHoraAcesso;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sessao_login_id")
	private SessaoLogin sessaoLogin;
	
}
