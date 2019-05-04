package bomberman;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

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
	
//	@Test
//	public void deBomba() {
//		Mapa mapa = new Mapa(2);
//		ArrayList<Bomberman> players =  mapa.getJugadores();
//		//players.get(0).moverse("der", mapa);
//		
//		//System.out.println(mapa);//borrar cuando terminen este test
//		Bomberman bomberman1 = new Bomberman(1,1);
//		Bomberman bomberman2 = new Bomberman(1,4);
//		
//		Bloque tran = new Bloque("transitable",1,2);
//		Bloque piedra1 = new Bloque("piedra",1,3);
//		mapa.setMatrizMapa(piedra1,1,3);
//		mapa.setMatrizMapa(bomberman2,1,4);
//		mapa.setMatrizMapa(tran, 1,2);//lo pongo para que siempre pueda poner una bomba ahi
//		mapa.setMatrizMapa(bomberman1,1,1);//pongo un bomber en el mapa (recordar que la bomba tiene rango 3)
//		
//		System.out.println(mapa);
//		
//		bomberman1.ponerBomba(mapa);
//		
//	    
//	    System.out.println(mapa);//borrar cuando terminen este test
//	    assertEquals(1,bomberman1.getCantMuertes());
//	    assertEquals(1,bomberman2.getCantMuertes());
//	    assertEquals("transitable",((Bloque) (mapa.getPosicionMapa(1,3))).queTipo());
//		//testear: -desde la pos donde puse la bomba (1,4) fijarse si habia piedra en algun lado (dentro de su rango) la rompio y corroborar que no siguio rompiendo,
//		//si habia bomberman en algun lado y lo mato y le reinicio su pos.
//		//si los obstaculos y las paredes no se rompieron.
//		//si los obstaculos paran la llama de la bomba (testear que no muera el bomberman detras de un obstaculo).
//		
//		
//		
//		
//		
//	}

}
