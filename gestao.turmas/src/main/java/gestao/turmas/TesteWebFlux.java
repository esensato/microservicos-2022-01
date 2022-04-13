package gestao.turmas;

import java.time.Duration;

import org.springframework.web.reactive.function.client.WebClient;

public class TesteWebFlux {
	
	public static void imprimir(Turma t) {
		System.out.println(t.getId() + " - " + t.getNome());
	}

	public static void main(String[] args) {

		WebClient cli = WebClient.create("http://localhost:8081");
		
		Turma t = new Turma();
		t.setNome("Turma XPTO");
		
		cli.post().uri("/turma/criar")
		.bodyValue(t)
		.retrieve()
		.bodyToMono(Turma.class)
		.subscribe(TesteWebFlux::imprimir);

		cli.get().uri("/turma/todos")
		.retrieve()
		.bodyToFlux(Turma.class).
		delaySubscription(Duration.ofSeconds(3))
		.subscribe(TesteWebFlux::imprimir);
		
		while(true);

	}

}
