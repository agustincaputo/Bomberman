package bomberman;

public class Juego {
	
	private static final int cantMaxMuertes = 10;
	private int tiempo;//para saber cuando finalizar el juego, puede ser por maxmuertes o tiempo
	
	public Juego() {
		Mapa mapa = new Mapa(2);
	}
	public Juego(int cantBombermans) {		
		Mapa mapa = new Mapa(cantBombermans);		
	}		
	public void bucleJuego() {
		//aca se hace el juego
		while(true) {
			
		}
	}
	
}
