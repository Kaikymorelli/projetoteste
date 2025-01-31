package com.Projetoteste.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "aluno")
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
   private Long id;

	
	private String cidade;
	
	private String email;
	
	private String nome;
	
	private String ra;
	
	private double renda;
	
	private String teleofone;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_turma", nullable = true)
	private Turma turma;
	
	
}
