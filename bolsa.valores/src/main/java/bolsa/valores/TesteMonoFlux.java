package bolsa.valores;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class TesteMonoFlux implements Subscriber<AcaoBolsa>{

	@Override
	public void onNext(AcaoBolsa item) {
		System.out.println("onNext = " + item.id + " = " + item.cotacao);

	}

	@Override
	public void onError(Throwable throwable) { }

	@Override
	public void onComplete() {
		System.out.println("onComplete");

	}

	@Override
	public void onSubscribe(Subscription s) {
		s.request(100);
		System.out.println("onSubscribe");

	}


	public static void imprimir(AcaoBolsa acao) {
		System.out.println(acao.id + " - " + acao.cotacao);
	}
	public static void main(String[] args) {

		Mono<AcaoBolsa> m = Mono.just(new AcaoBolsa(AcaoBolsa.IDS[0], 100.0f)).
				delayElement(Duration.ofSeconds(2));

		m.subscribe(TesteMonoFlux::imprimir);
		System.out.println("FIM MONO");

		List<AcaoBolsa> acoes = new ArrayList<AcaoBolsa>();

		Flux<AcaoBolsa> f = Flux.fromIterable(acoes)
				.delayElements(Duration.ofSeconds(5));

		Random r = new Random();
		for (int i = 0; i < 100; i++) {
			final int valor = (-50 + r.nextInt(100));
			final int id = r.nextInt(AcaoBolsa.IDS.length);
			acoes.add(new AcaoBolsa(AcaoBolsa.IDS[id], 100 - valor));
		}

		f.subscribe(new TesteMonoFlux());
		System.out.println("FIM FLUX");	

		while(true);

	}

}
