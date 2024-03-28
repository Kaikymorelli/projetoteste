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

import com.Projetoteste.entities.Turma;
import com.Projetoteste.service.TurmaService;

@RestController
@RequestMapping("/turma")
public class TurmaController {

private final TurmaService TurmaService;
	
	@Autowired
	public TurmaController(TurmaService TurmaService) {
		this.TurmaService = TurmaService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Turma> getTurmaById(@PathVariable Long id) {
		Turma Turma = TurmaService.getTurmaById(id);
		if (Turma != null) {
			return ResponseEntity.ok(Turma);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Turma>> getAllTurma() {
		List<Turma> Turma = TurmaService.getAllTurma();
		return ResponseEntity.ok(Turma);
	}

	@PostMapping("/")
	public ResponseEntity<Turma> criarTurma(@RequestBody Turma Turma) {
		Turma criarTurma = TurmaService.salvarTurma(Turma);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarTurma);
	}


	@PutMapping("/{id}")
	public ResponseEntity<Turma> updateTurma(@PathVariable Long id, @RequestBody Turma Turma) {
		Turma updatedTurma= TurmaService.updateTurma(id, Turma);
		if (updatedTurma != null) {
			return ResponseEntity.ok(updatedTurma);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTurma(@PathVariable Long id) {
		boolean deleted = TurmaService.deleteTurma(id);
		if (deleted) {
			return ResponseEntity.ok().body("O Turma foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
