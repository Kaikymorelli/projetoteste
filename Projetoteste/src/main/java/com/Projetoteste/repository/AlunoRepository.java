package com.Projetoteste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Projetoteste.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
