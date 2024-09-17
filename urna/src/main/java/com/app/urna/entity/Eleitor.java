package com.app.urna.entity;


import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class Eleitor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Nome não pode ser nulo!")
	private String nome;

    @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 dígitos")
	private String cpf;
	
	@NotNull
	private String profissao;
	
	@NotNull
	private String telefoneCelular;
	
	private String telefoneFixo;
    
    private String email;

    @Enumerated(EnumType.STRING)
    private StatusEleitor status;
}

