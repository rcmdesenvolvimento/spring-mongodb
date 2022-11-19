package com.rcm.sistemas.usandomongo.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

// Collection é a tabela, documento são os registros.

@Data
@Document
public class Funcionario {
	
	@Id
	private String codigo;
	
	private String nome;
	private Integer idade;
	private String bairro;
	private BigDecimal salario; 
	
	@DBRef  // Referência de Collenction, dentro de outra
	private Funcionario chefe;

}
