package bomberman;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class TestDelJuego {

	@Test
	public void debuggeoTodoAca() {			
		Juego juegoTest =  new Juego(2);		
	}
	
	@Test
	public void deMovimiento() {
		Mapa mapaTest = new Mapa(2);
		
		System.out.println("MAPA DEL JUEGO PARA DEL JUEGO 2 BOMBERMAN");
		System.out.println(mapaTest);
		
		ArrayList<Bomberman> players =  mapaTest.getJugadores();
		int contDerecha = 0;
			
			players.get(0).moverse("der", mapaTest);		
			if(mapaTest.getPosicionMapa(players.get(0).getPosX(),players.get(0).getPosY()+1) instanceof Bloque ){
				if(((Bloque)(mapaTest.getPosicionMapa(players.get(0).getPosX(),players.get(0).getPosY()+1))).queTipo()=="Transitable") {
					
				}
			}

			if(mapaTest.getPosicionMapa(players.get(0).getPosX(),players.get(0).getPosY()+1) instanceof Bloque ){
				if(((Bloque)(mapaTest.getPosicionMapa(players.get(0).getPosX(),players.get(0).getPosY()+1))).queTipo()=="Transitable")
					contDerecha++;
			}
			players.get(0).moverse("der", mapaTest);
		

			
			System.out.println("BOMBERMAN 1 se mueve a abajo");
			players.get(0).moverse("abajo", mapaTest);

			
			System.out.println("BOMBERMAN 1 se mueve a abajo");
			players.get(0).moverse("abajo", mapaTest);
		
		
	}

}
