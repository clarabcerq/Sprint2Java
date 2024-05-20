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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pergunta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pergunta implements Serializable{

	//pergunta não pode ser enviado vazio
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pergunta")
	@SequenceGenerator(name = "seq_pergunta", sequenceName = "seq_pergunta", allocationSize = 1)
	@Column(name = "id_perg")
	private int idPergunta;
	
	@Column(name = "conteudo_perg")
	private String conteudoPergunta;
	
	@Column(name = "data_hora_perg")
	private Timestamp dataHoraPerg;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cadastro_id_cadastro")
	private Cadastro cadastro;
	
}
