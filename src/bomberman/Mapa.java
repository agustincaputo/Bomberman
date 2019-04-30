package bomberman;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Mapa{

	public static final int COLMAX = 15;
	public static final int FILMAX = 11;
	private Object matrizMapa[][];
	private ArrayList <Bomberman> jugadores [];
	

	public Mapa(int cantBombermans) {
		this.matrizMapa = new Object [FILMAX][COLMAX];
		this.crearPiedras();		
		this.jugadores = new ArrayList[cantBombermans];
		this.crearParedes();
		this.crearObstaculos();
		this.crearPosBomberman(cantBombermans);
	}
	
	public void crearParedes() {
	
		
	
		for(int i = 0 ; i < FILMAX ; i++) {
			if(i== 0 || i == FILMAX) {
				for(int j = 0; j < COLMAX ; j ++ ) {
					Bloque pared = new Bloque("pared",i,j);
					matrizMapa[i][j] = pared;
				}
				}
			else {
				Bloque pared1 = new Bloque("pared",i,0);
				Bloque pared2 = new Bloque("pared",i,COLMAX);
				 matrizMapa[i][0] = pared1;
				 matrizMapa[i][COLMAX] = pared2;
			}		
		}
	}
	
	public void crearObstaculos() {
		
		
		for(int i = 2 ; i < FILMAX-1; i+=2) {
			for(int j = 2 ; j < COLMAX-1; j+=2) {
				Bloque obstaculo = new Bloque("obstaculo",i,j);
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
		
		int cantPiedras=50;
		int vecFila[] = {3,5,7};
		int vecCol[] = {3,5,7,9,11};		
		int randomFil;
		int randomCol;
		int i=0;
		while(i!=cantPiedras) {
			
		 randomFil =vecFila[ThreadLocalRandom.current().nextInt(0, 2 + 1)];
		 randomCol =vecCol[ThreadLocalRandom.current().nextInt(0, 4 + 1)];
			if(matrizMapa[randomFil][randomCol]==null) {
				Bloque piedra = new Bloque("piedra",randomFil,randomCol);
				matrizMapa[randomFil][randomCol]=piedra;
				i++;
			}
		}
	
	}
	
	
}
