package bolsa.valores;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public static void imprimir(AcaoBolsa acao) {
		System.out.println(acao.id + " => " + acao.cotacao);
	}
	@Override
	public void run(String... args) throws Exception {
		WebClient cli = WebClient.create("http://localhost:8081");
		Flux<AcaoBolsa> cotacoes = cli.get().
				uri("/monitorar").retrieve().bodyToFlux(AcaoBolsa.class);
		System.out.println("Requisicao efetuada!");
		cotacoes.subscribe(new ProcessarAcoes());
		while(true);
		
	}

}
