package io.github.wiriswernek.sender.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusDTO {
	
	private Integer codigo;
	private String mensagem;

}
