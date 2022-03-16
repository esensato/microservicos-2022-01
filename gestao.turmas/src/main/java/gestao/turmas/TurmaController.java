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

@RestController
@RequestMapping(value = "/turma")
public class TurmaController {
	
	@Autowired
	TurmaDAO dao;
	
	@PostMapping(path = "/criar")
	public ResponseEntity<Turma> criar(@RequestBody Turma turma) {
		
		Turma turmaCriada = dao.save(turma);
		return new ResponseEntity<Turma>(turmaCriada, HttpStatus.OK);
		
		
	}
	
	@PutMapping(path = "/adicionar/{turma}/{total}")
	public ResponseEntity<Turma> adicionar(@PathVariable String turma, @PathVariable Integer total) {
		
		Turma t = dao.findByNome(turma);
		
		if (t != null) {
			t.setTotal(t.getTotal() + total);
			dao.save(t);
			return new ResponseEntity<Turma>(t, HttpStatus.OK);
		} else {
			return new ResponseEntity<Turma>(HttpStatus.NOT_FOUND);
		}
		
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
	public ResponseEntity<Iterable<Turma>> todos() {
		
		return new ResponseEntity<Iterable<Turma>>(dao.findAll(), HttpStatus.OK);
		
	}
}
