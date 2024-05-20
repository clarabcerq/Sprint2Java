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
@Table(name = "resposta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Resposta implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_resposta")
	@SequenceGenerator(name = "seq_resposta", sequenceName = "seq_resposta", allocationSize = 1)
	@Column(name = "id_resp")
	private int idResposta;
	
	@Column(name = "conteudo_resposta")
	private String conteudoResposta;
	
	@Column(name = "data_hora_resposta")
	private Timestamp dataHoraResposta;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pergunta_id_perg")
	private Pergunta pergunta;
	
}
