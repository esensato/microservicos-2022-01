package gestao.turmas;

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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping(value = "/turma")
public class TurmaController {

	@Autowired
	TurmaDAO dao;

	@Operation(summary = "Criar uma nova turma", 
			description = "Cria uma nova turma de alunos", 
			tags = { "Criar Turma" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Turma criada",
			content = { @Content(mediaType = "application/json",
			schema = @Schema(implementation = Turma.class)) }),
			@ApiResponse(responseCode = "400", description = "Total inválido",
			content = @Content) })	
	@PostMapping(path = "/criar")
	public Mono<Turma> criar(@RequestBody Turma turma) {

		if (turma.getTotal() < 0) {
			return Mono.empty();
		}
		return dao.save(turma);

	}

	@PutMapping(path = "/adicionar/{turma}/{total}")
	public Mono<Turma> adicionar(@PathVariable String turma, @PathVariable Integer total) {

		Turma t = dao.findByNome(turma);

		if (t != null) {
			t.setTotal(t.getTotal() + total);
			dao.save(t);
			return Mono.just(t);
		}
		else return Mono.empty();

	}

	@DeleteMapping(path = "/remover/{turma}/{total}")
	public ResponseEntity<Turma> remover(@PathVariable String turma, @PathVariable Integer total) {

		Turma t = dao.findByNome(turma);

		if (t != null) {
			t.setTotal(t.getTotal() - total);
			dao.save(t);
			return new ResponseEntity<Turma>(t, HttpStatus.OK);
		} else {
			return new ResponseEntity<Turma>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping(path="/todos")
	public Flux<Turma> todos() {

		return dao.findAll();

	}
}
