package io.github.wiriswernek.sender.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.wiriswernek.sender.model.entity.EmailEntity;

public interface EmailRepository extends JpaRepository<EmailEntity,Long> {
	
}
