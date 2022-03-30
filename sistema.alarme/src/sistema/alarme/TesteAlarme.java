package sistema.alarme;

public class TesteAlarme {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		
		Sensor s1 = new Sensor();
		Sensor s2 = new Sensor();
		
		Alarme a = new Alarme();
		
		s1.addObserver(a);
		s2.addObserver(a);
		
		for (int i = 0; i < 10; i++) {
			s1.acionar();
			Thread.sleep(2000);
			s2.acionar();
		}

		
		System.out.println("Fim");

	}

}
