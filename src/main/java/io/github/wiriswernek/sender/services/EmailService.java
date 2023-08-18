package io.github.wiriswernek.sender.services;

import java.time.LocalDateTime;

import javax.mail.MessagingException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import io.github.wiriswernek.sender.model.dto.EmailDTO;
import io.github.wiriswernek.sender.model.dto.StatusDTO;
import io.github.wiriswernek.sender.model.entity.EmailEntity;
import io.github.wiriswernek.sender.model.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailService {
	private final JavaMailSender javaMailSender;
	private final EmailRepository repository;

    public StatusDTO enviar(EmailDTO email) {

        SimpleMailMessage mensagem = new SimpleMailMessage();
        mensagem.setTo(email.getPara());
        mensagem.setSubject(email.getTitulo());
        mensagem.setText(email.getConteudo());
        javaMailSender.send(mensagem);
		
		repository.save(mapper(email));
		return new StatusDTO(HttpStatus.OK.value(), "Email enviado com sucesso!");
    }

    public void enviarEmailComAnexo(String para, String titulo, String conteudo, String arquivo) throws MessagingException {
        log.info("Enviando email com anexo");
        var mensagem = javaMailSender.createMimeMessage();

        var helper = new MimeMessageHelper(mensagem, true);

        helper.setTo(para);
        helper.setSubject(titulo);
        helper.setText(conteudo, true);

        helper.addAttachment("image1.jpeg", new ClassPathResource(arquivo));

        javaMailSender.send(mensagem);
        log.info("Email com anexo enviado com sucesso.");
    }

	private EmailEntity mapper(EmailDTO dto){
		EmailEntity entity = new EmailEntity();
		entity.setPara(dto.getPara());
		entity.setTitulo(dto.getTitulo());
		entity.setConteudo(dto.getConteudo());
		entity.setEnviadoEm(LocalDateTime.now());

		return entity;
	}
}
