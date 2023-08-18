package io.github.wiriswernek.sender.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.wiriswernek.sender.model.dto.EmailDTO;
import io.github.wiriswernek.sender.services.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping( "/email" )
@Slf4j
@RequiredArgsConstructor
public class EmailController {
	private final EmailService service;
	
	@PostMapping( path = "/enviar" )
	public ResponseEntity enviar(@RequestBody EmailDTO email) {
		try {
			return ResponseEntity.ok( service.enviar(email) );
		} catch ( Exception e ) {
			log.info( e.getMessage() );
			log.info( e.toString() );
			return ResponseEntity.internalServerError().body( e.getMessage() );

		}
	}
}
