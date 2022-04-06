package bolsa.valores;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class BolsaController {

	List<AcaoBolsa> acoes = new ArrayList<AcaoBolsa>();
	
	@GetMapping("/monitorar")
	public Flux<AcaoBolsa> monitorarAcoes() {

		Random r = new Random();
		for (int i = 0; i < 1000; i++) {
			final int valor = (-50 + r.nextInt(100));
			final int id = r.nextInt(AcaoBolsa.IDS.length);
			acoes.add(new AcaoBolsa(AcaoBolsa.IDS[id], 100 - valor));
		}
		
		Flux<AcaoBolsa> f = Flux.fromIterable(acoes);
		
		System.out.println("Requisicao efetuada...");
		return f;
	}
	
}
