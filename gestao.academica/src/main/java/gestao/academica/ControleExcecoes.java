package gestao.academica;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControleExcecoes {
	
	@ResponseStatus(
			value = HttpStatus.BAD_REQUEST,
			reason = "Informar um número como parâmetro na requisição")
	@ExceptionHandler(RequisicaoInvalida.class)
	public void requisicaoInvalidaHandler(RequisicaoInvalida e) {
		e.printStackTrace();
	}

}
