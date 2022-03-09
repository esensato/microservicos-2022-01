package gestao.academica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	@GetMapping("/listar")
	public ResponseEntity<List<AlunoBean>> obterAlunos() {

		logger.debug("### obtendo todos os alunos... " + appName);
		return new ResponseEntity<List<AlunoBean>>(alunos, HttpStatus.OK);

	}

	@GetMapping("/obter/{id}")
	public ResponseEntity<AlunoBean> obterAluno(@PathVariable String id) {

		try {
			Integer.parseInt(id);
		} catch (Exception e) {
			throw new RequisicaoInvalida();			
		}

		AlunoBean ret = null;

		if (id.equals("1")) {
			ret = new AlunoBean(1, "Joao", "RI");
		} else if (id.equals("2")) {
			ret = new AlunoBean(2, "Maria", "SI");
		}

		if (ret != null)
			return new ResponseEntity<AlunoBean>(ret, HttpStatus.OK);
		else 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	static List<AlunoBean> alunos = new ArrayList<AlunoBean>();

	@PostMapping("/cadastrar")
	public ResponseEntity<String> cadastrar(@Valid @RequestBody AlunoBean aluno) {

		alunos.add(aluno);

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
