package bomberman;

import java.util.ArrayList;

public class Mapa extends Juego{

	public static final int COLMAX = 15;
	public static final int FILMAX = 11;
	private Object matrizMapa[][];
	private ArrayList <Bomberman> jugadores [];
	
	
	public Mapa(int cantBombermans) {
		this.matrizMapa = new Object [FILMAX][COLMAX];
		this.jugadores = new ArrayList[cantBombermans];
		this.crearParedes();
		this.crearObstaculos();
		this.crearPosBomberman(cantBombermans);
		this.crearPiedras();		
	}
	
	public void crearParedes() {
	
		Bloque pared = new Bloque("pared");
	
		for(int i = 0 ; i < FILMAX ; i++) {
			if(i== 0 || i == FILMAX) {
				for(int j = 0; j < COLMAX ; j ++ ) 
					 matrizMapa[i][j] = pared;
				}
			else {
				 matrizMapa[i][0] = pared;
				 matrizMapa[i][COLMAX] = pared;
			}		
		}
	}
	
	public void crearObstaculos() {
		Bloque obstaculo = new Bloque("obstaculo");
		
		for(int i = 2 ; i < FILMAX-1; i+=2) {
			for(int j = 2 ; j < COLMAX-1; j+=2) {
				matrizMapa[i][j] = obstaculo; 
			}			
		}
		
	}
	public void crearPosBomberman(int cantBombermans) {
		int i=0;
		matrizMapa[1][1] =  jugadores[i++];
		matrizMapa[FILMAX-1][COLMAX-1] = jugadores[i++];
		if(cantBombermans == 4) {
			matrizMapa[1][COLMAX-1] = jugadores[i++];
			matrizMapa[FILMAX-1][1] = jugadores[i++]; 					
		}
		if(cantBombermans == 3)
			matrizMapa[1][COLMAX-1] = jugadores[i++];
		
	}		
	public void crearPiedras() {
		
	}
	
	
}
