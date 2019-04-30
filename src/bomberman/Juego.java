package bomberman;

public class Juego {
	
	private static final int cantMaxMuertes = 10;
	private int tiempo;//para saber cuando finalizar el juego, puede ser por maxmuertes o tiempo
	
	public Juego(int cantBombermans) {		
		Mapa mapa = new Mapa(cantBombermans);		
	}		
	public Juego() {
		this(2);// no tengo idea si funciona bien 
	}
}
