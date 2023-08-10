package io.github.wiriswernek.sender.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "EMAILS_ENVIADOS")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmailEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "PARA")
	private String para;

	@Column(name = "TITULO")
	private String titulo;

	@Column(name = "CONTEUDO")
	private String conteudo;

	@Column(name = "ENVIADO_EM")
	private LocalDateTime enviadoEm;

}
