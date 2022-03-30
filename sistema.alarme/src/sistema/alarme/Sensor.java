package sistema.alarme;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class Sensor extends Observable{

	public void acionar() {
		setChanged();
		notifyObservers("Sensor acionado!");
	}
	
}
