package gestao.academica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AlunoController {

	@Value("${app.name}")
	String appName;

	private static final Logger logger = 
			LoggerFactory.getLogger(AlunoController.class);
	
	@Autowired
	AlunoDAO dao;
	
	@GetMapping("/listar")
	public ResponseEntity<Iterable<AlunoBean>> obterAlunos() {

		logger.debug("### obtendo todos os alunos... " + appName);
		return new ResponseEntity<Iterable<AlunoBean>>(dao.findAll(), HttpStatus.OK);

	}
	
	@GetMapping("/turma/{id}")
	public ResponseEntity<Iterable<AlunoBean>> obterAlunosPorTurma(@PathVariable String id) {

		logger.debug("### obtendo todos os alunos... turma = " + id);
		return new ResponseEntity<Iterable<AlunoBean>>(dao.findByTurma(id), HttpStatus.OK);

	}
	
	@GetMapping("/obter/{idTurma}/{idCurso}")
	public ResponseEntity<Iterable<AlunoBean>> obterTurmaCurso(@PathVariable String idTurma, @PathVariable String idCurso) {

		logger.debug("### obtendo todos os alunos... turma = " + idTurma + "/" + idCurso);
		return new ResponseEntity<Iterable<AlunoBean>>(dao.obterTurmaCurso(idTurma, idCurso), HttpStatus.OK);

	}

	@GetMapping("/obter/{id}")
	public ResponseEntity<AlunoBean> obterAluno(@PathVariable Integer id) {

		Optional<AlunoBean> ret = dao.findById(id);

		if (ret.isPresent())
			return new ResponseEntity<AlunoBean>(ret.get(), HttpStatus.OK);
		else 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<String> cadastrar(@Valid @RequestBody AlunoBean aluno) {

		dao.save(aluno);

		return new ResponseEntity<>(HttpStatus.OK);

	}
	
	

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<String, String>();
		
		errors.put("codigo", "BAD");
		
		ex.getBindingResult().getFieldErrors().forEach(error ->
		errors.put(error.getField(), error.getDefaultMessage()));
		
		return errors;
	}
	
	

}
