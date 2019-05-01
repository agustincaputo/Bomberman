package bomberman;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Mapa {

	public static final int COLMAX = 15;
	public static final int FILMAX = 11;
	private Object matrizMapa[][];
	private ArrayList<Bomberman> jugadores;

	public Mapa(int cantBombermans) {
		this.matrizMapa = new Object[FILMAX][COLMAX];
		jugadores = new ArrayList<Bomberman>();
		this.crearParedes();
		this.crearPasillos();
		this.crearPosBomberman(cantBombermans);
		this.crearObstaculos();
		this.crearPiedras();
		
	}

	@Override
	public String toString() {
		for (int i = 0; i < FILMAX; i++) {
			for (int j = 0; j < COLMAX; j++) {
				System.out.print(String.format("%-15s", matrizMapa[i][j]) + "|");
			}
			System.out.println("\n");
		}
		;
		return "";
	}

	public void crearPasillos() {
		for(int i=1; i<FILMAX-1 ;i++) {
			for(int j=1; j<COLMAX-1; j++) {
				Bloque transitable = new Bloque ("transitable",i,j);
				matrizMapa[i][j]= transitable;
			}
		}
			
		
	}
	public void crearParedes() {

		for (int i = 0; i < FILMAX; i++) {
			if (i == 0 || i == FILMAX - 1) {
				for (int j = 0; j < COLMAX; j++) {
					Bloque pared = new Bloque("pared", i, j);
					matrizMapa[i][j] = pared;
				}
			} else {
				Bloque pared1 = new Bloque("pared", i, 0);
				Bloque pared2 = new Bloque("pared", i, COLMAX - 1);
				matrizMapa[i][0] = pared1;
				matrizMapa[i][COLMAX - 1] = pared2;
			}
		}
	}

	public void crearObstaculos() {

		for (int i = 2; i < FILMAX - 1; i += 2) {
			for (int j = 2; j < COLMAX - 1; j += 2) {
				Bloque obstaculo = new Bloque("obstaculo", i, j);
				matrizMapa[i][j] = obstaculo;
			}
		}

	}

	public void crearPosBomberman(int cantBombermans) {
		int i = 0;
		jugadores.add(new Bomberman(1, 1));
		jugadores.add(new Bomberman(FILMAX - 2, COLMAX - 2));
		matrizMapa[1][1] = jugadores.get(i++);
		matrizMapa[FILMAX - 2][COLMAX - 2] = jugadores.get(i++);
		if (cantBombermans > 3) {
			jugadores.add(new Bomberman(1, COLMAX - 2));
			jugadores.add(new Bomberman(FILMAX - 2, 1));
			matrizMapa[1][COLMAX - 2] = jugadores.get(i++);
			matrizMapa[FILMAX - 2][1] = jugadores.get(i++);
		}
		if (cantBombermans == 3) {
			jugadores.add(new Bomberman(1, COLMAX - 2));
			matrizMapa[1][COLMAX - 2] = jugadores.get(i++);
		}

	}

	public void crearPiedras() {

		int cantPiedras = 38;
		int vecFila[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int vecCol[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
		int randomFil;
		int randomCol;
		int i = 0;

		while (i != cantPiedras) {
			randomFil = vecFila[ThreadLocalRandom.current().nextInt(0, 8 + 1)];
			randomCol = vecCol[ThreadLocalRandom.current().nextInt(0, 12 + 1)];
			if (matrizMapa[randomFil][randomCol] instanceof Bloque) {
				if(((Bloque)matrizMapa[randomFil][randomCol]).queTipo()=="transitable"){
					Bloque piedra = new Bloque("piedra", randomFil, randomCol);
					matrizMapa[randomFil][randomCol] = piedra;
					i++;
				}
			}
		}
	}
	
	public boolean esTransitable(int x, int y) {
		if(((Bloque)matrizMapa[x][y]).queTipo()=="transitable")
			return true;
		return false;
	}
	
}
