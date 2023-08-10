package io.github.wiriswernek.sender.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmailDTO {
	private String para;
	private String titulo;
	private String conteudo;
}
