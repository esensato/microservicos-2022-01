package webflux;

import java.time.Duration;

import reactor.core.publisher.Mono;

public class TesteFlux {

	public static void main(String[] args) {
		
		Mono<String> produtor = Mono.just("Teste Mono").
				delayElement(Duration.ofSeconds(10)).log();
		
		produtor.subscribe(System.out::println);
		
		System.out.println("FIM");
		
		while(true);

	}

}
