package bomberman;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Mapa {


	public static final int COLMAX = 15;
	public static final int FILMAX = 11;
	private Entidad matrizMapa[][];
	private ArrayList<Bomberman> jugadores;


	public Mapa() {
		this.matrizMapa = new Entidad[FILMAX][COLMAX];
		jugadores = new ArrayList<Bomberman>();
		this.crearParedes();
		this.crearPasillos();
		this.crearObstaculos();
		this.crearPiedras();		

	}

	public void setMatrizMapa(Entidad obj, int x, int y) {
		this.matrizMapa[x][y] = obj;
	}

	public Entidad getPosicionMapa(int x, int y) {
		return this.matrizMapa[x][y];
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

	
	public void creaBomberman() {
		int vec [][]= {{1,1},{9,13},{1,13},{9,1}};
		boolean bandera = false;
		
		for(int j=0; j<=jugadores.size() && j<4 && bandera==false ;j++) {
			if((matrizMapa[vec[j][0]][vec[j][1]]).esBomberman() == false) {
				Bomberman bomber = new Bomberman(vec[j][0],vec[j][1]);
				matrizMapa[bomber.getPosX()][bomber.getPosY()] = bomber;
				jugadores.add(bomber);
				bandera=true;
			}
		}	
		
	}

	public void crearPiedras() {

		int cantPiedras = 38;
		int vecFila[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int vecCol[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
		int ranF;
		int ranC;
		int i = 0;

		while (i != cantPiedras) {
			ranF = vecFila[ThreadLocalRandom.current().nextInt(0, 8 + 1)];
			ranC = vecCol[ThreadLocalRandom.current().nextInt(0, 12 + 1)];
			if (matrizMapa[ranF][ranC] instanceof Bloque) {
				if(((Bloque)matrizMapa[ranF][ranC]).queTipo()=="transitable"){
					if(!(ranF==1 && ranC==2) && !(ranF==2 && ranC==1) && !(ranF==1 && ranC==12) && !(ranF==2 && ranC==13) && !(ranF==8 && ranC==1) && !(ranF==9 && ranC==2) && !(ranF==9 && ranC==12) && !(ranF==8 && ranC==13)) {
						//hermoso if
						//el if hace que no se puedan poner piedras al lado del bomberman y se quede sin poder moverse 
						Bloque piedra = new Bloque("piedra", ranF, ranC);
						matrizMapa[ranF][ranC] = piedra;
						i++;
					}
				}
			}
		}
	}

	public boolean esTransitable(int x, int y) {
		if(((Bloque)matrizMapa[x][y]).queTipo()=="transitable")
			return true;
		return false;
	}



	public Entidad[][] getMatrizMapa() {
		return matrizMapa;
	}

	public void setMatrizMapa(Entidad[][] matrizMapa) {
		this.matrizMapa = matrizMapa;
	}

	public ArrayList<Bomberman> getJugadores() {
		return jugadores;
	}

	public void setJugadores(ArrayList<Bomberman> jugadores) {
		this.jugadores = jugadores;
	}
}
