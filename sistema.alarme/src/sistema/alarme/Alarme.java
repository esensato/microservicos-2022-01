package sistema.alarme;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class Alarme implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		
		System.out.println("Ocorreu um evento de " + arg.toString() + " - " + o);
	}

}
