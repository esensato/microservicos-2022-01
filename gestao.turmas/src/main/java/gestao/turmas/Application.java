package gestao.turmas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	private static final Logger logger =  LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("INICIADO!");
		
//		RestTemplate req = new RestTemplate();
//		final String URL = "http://localhost:8081/turma/criar";
//		Turma novaTurma = new Turma();
//		novaTurma.setNome("TURMA X");
//		novaTurma.setTotal(10);
//		ResponseEntity<Turma> criada = req.postForEntity(URL, novaTurma, Turma.class);
//		if (criada.getStatusCode() == HttpStatus.OK) {
//			logger.info("Turma criada: " + criada.getBody().getId());
//		} else {
//			logger.error("Erro: " + criada.getStatusCodeValue());
//		}
	}

}
