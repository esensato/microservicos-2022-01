package noticia.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticiaController {
	
	@Autowired
	NoticiaProducer producer;
	
	@GetMapping("/enviar/{mensagem}")
	public ResponseEntity<String> enviar(@PathVariable String mensagem) {
		producer.enviar(mensagem);
		return new ResponseEntity<String>("Enviado", HttpStatus.OK);
		
	}

}
