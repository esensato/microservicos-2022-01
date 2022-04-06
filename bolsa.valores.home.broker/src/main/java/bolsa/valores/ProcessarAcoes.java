package bolsa.valores;

import org.reactivestreams.Subscription;

import reactor.core.publisher.BaseSubscriber;

public class ProcessarAcoes extends BaseSubscriber<AcaoBolsa>{

	int contador = 0;
	
	@Override
	protected void hookOnSubscribe(Subscription subscription) {
		request(10);
	}
	
	@Override
	protected void hookOnNext(AcaoBolsa value) {

		contador++;
		System.out.println("Processando = " + value.id + " = " + value.cotacao);
		if (contador == 10) {
			contador = 0;
			// processar as 10 acoes
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			request(10);
		}
		
	}
	
}
