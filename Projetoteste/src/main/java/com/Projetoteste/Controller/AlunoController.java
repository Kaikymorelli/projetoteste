package com.Projetoteste.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Projetoteste.entities.Aluno;
import com.Projetoteste.service.AlunoService;
@RestController
@RequestMapping("/aluno")
public class AlunoController {

private final AlunoService AlunoService;
	
	@Autowired
	public AlunoController(AlunoService AlunoService) {
		this.AlunoService = AlunoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Aluno> getAlunoById(@PathVariable Long id) {
		Aluno Aluno = AlunoService.getAlunoById(id);
		if (Aluno != null) {
			return ResponseEntity.ok(Aluno);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Aluno>> getAllAluno() {
		List<Aluno> Aluno = AlunoService.getAllAluno();
		return ResponseEntity.ok(Aluno);
	}

	@PostMapping("/")
	public ResponseEntity<Aluno> criarAluno(@RequestBody Aluno Aluno) {
		Aluno criarAluno = AlunoService.salvarAluno(Aluno);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarAluno);
	}


	@PutMapping("/{id}")
	public ResponseEntity<Aluno> updateAluno(@PathVariable Long id, @RequestBody Aluno Aluno) {
		Aluno updatedAluno= AlunoService.updateAluno(id, Aluno);
		if (updatedAluno != null) {
			return ResponseEntity.ok(updatedAluno);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAluno(@PathVariable Long id) {
		boolean deleted = AlunoService.deleteAluno(id);
		if (deleted) {
			return ResponseEntity.ok().body("O Aluno foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
