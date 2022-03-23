package gestao.turmas;

import java.util.Random;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class TesteServico implements HealthIndicator{

	@Override
	public Health health() {
		Health ret = Health.up().build();
		
		Random r = new Random();
		
		int v = r.nextInt(10);
		
		if (v < 3) {
			ret = Health.down().build();
		} else if (v >=3 && v < 8) {
			ret = Health.unknown().build();
		} else {
			ret = Health.outOfService().build();
		}
		
		return ret;
	}

}
