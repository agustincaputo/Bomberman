package bomberman;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.Assert;

public class TestDelJuego {

	@Test
	public void obtenerCantBombers() {			
		Mapa mapaTest =  new Mapa(2);	
		assertEquals(2, mapaTest.getJugadores().size());
		Mapa mapaTest2 =  new Mapa(3);	
		assertEquals(3, mapaTest2.getJugadores().size());
		Mapa mapaTest3 =  new Mapa(4);	
		assertEquals(4, mapaTest3.getJugadores().size());
		Mapa mapaTest4 =  new Mapa(5);	
		assertEquals(4, mapaTest4.getJugadores().size());
	}
	
	@Test
	public void deMovimiento() {
		Mapa mapaTest = new Mapa(2);
		
		ArrayList<Bomberman> players =  mapaTest.getJugadores();
		int x ,y;
		x=players.get(0).getPosX();
		y=players.get(0).getPosY();
		
		players.get(0).moverse("der", mapaTest);		
		if(mapaTest.getPosicionMapa(x,y+1) instanceof Bloque ){
			if(((Bloque)(mapaTest.getPosicionMapa(x,y+1))).queTipo()=="Transitable") {
				assertEquals(y+1, players.get(0).getPosY());
			}
			else {
				assertEquals(y, players.get(0).getPosY());
			}
		}
		
		x=players.get(0).getPosX();
		y=players.get(0).getPosY();
		players.get(0).moverse("der", mapaTest);	
		if(mapaTest.getPosicionMapa(x,y+1) instanceof Bloque ){
			if(((Bloque)(mapaTest.getPosicionMapa(x,y+1))).queTipo()=="Transitable") {
				assertEquals(y+1, players.get(0).getPosY());
			}
			else {
				assertEquals(y, players.get(0).getPosY());
			}
		}
		
		x=players.get(0).getPosX();
		y=players.get(0).getPosY();
		players.get(0).moverse("abajo", mapaTest);	
		if(mapaTest.getPosicionMapa(x+1,y) instanceof Bloque ){
			if(((Bloque)(mapaTest.getPosicionMapa(x+1,y))).queTipo()=="Transitable") {
				assertEquals(x+1, players.get(0).getPosX());
			}
			else {
				assertEquals(x, players.get(0).getPosX());
			}
		}

		x=players.get(0).getPosX();
		y=players.get(0).getPosY();
		players.get(0).moverse("abajo", mapaTest);	
		if(mapaTest.getPosicionMapa(x+1,y) instanceof Bloque ){
			if(((Bloque)(mapaTest.getPosicionMapa(x+1,y))).queTipo()=="Transitable") {
				assertEquals(x+1, players.get(0).getPosX());
			}
			else {
				assertEquals(x, players.get(0).getPosX());
			}
		}
		
		x=players.get(0).getPosX();
		y=players.get(0).getPosY();
		players.get(0).moverse("arriba", mapaTest);	
		if(mapaTest.getPosicionMapa(x-1,y) instanceof Bloque ){
			if(((Bloque)(mapaTest.getPosicionMapa(x-1,y))).queTipo()=="Transitable") {
				assertEquals(x-1, players.get(0).getPosX());
			}
			else {
				assertEquals(x, players.get(0).getPosX());
			}
		}
		
		x=players.get(0).getPosX();
		y=players.get(0).getPosY();
		players.get(0).moverse("arriba", mapaTest);	
		if(mapaTest.getPosicionMapa(x-1,y) instanceof Bloque ){
			if(((Bloque)(mapaTest.getPosicionMapa(x-1,y))).queTipo()=="Transitable") {
				assertEquals(x-1, players.get(0).getPosX());
			}
			else {
				assertEquals(x, players.get(0).getPosX());
			}
		}
		
		x=players.get(0).getPosX();
		y=players.get(0).getPosY();
		players.get(0).moverse("izq", mapaTest);	
		if(mapaTest.getPosicionMapa(x,y-1) instanceof Bloque ){
			if(((Bloque)(mapaTest.getPosicionMapa(x,y-1))).queTipo()=="Transitable") {
				assertEquals(y-1, players.get(0).getPosY());
			}
			else {
				assertEquals(y, players.get(0).getPosY());
			}
		}
		
		x=players.get(0).getPosX();
		y=players.get(0).getPosY();
		players.get(0).moverse("izq", mapaTest);	
		if(mapaTest.getPosicionMapa(x,y-1) instanceof Bloque ){
			if(((Bloque)(mapaTest.getPosicionMapa(x,y-1))).queTipo()=="Transitable") {
				assertEquals(y-1, players.get(0).getPosY());
			}
			else {
				assertEquals(y, players.get(0).getPosY());
			}
		}	
	}
	
	@Test
	public void deBomba() {
		Mapa mapa = new Mapa(2);
		ArrayList<Bomberman> players =  mapa.getJugadores();
//		players.get(1);
		Bomberman nuevo = new Bomberman(1,3);
		System.out.println(mapa);
		mapa.setMatrizMapa(nuevo,1,3);
		nuevo.ponerBomba(mapa);
		System.out.println(mapa);
		
	}

}
