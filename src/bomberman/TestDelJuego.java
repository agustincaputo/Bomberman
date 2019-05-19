package bomberman;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class TestDelJuego {
	
//	@Before
//	public void creaMapaHarcodeado() {
//		Mapa mapa = new Mapa(2);
//		
//	}
	@Test
	public void borrame() {
		Mapa mapa = new Mapa();

		mapa.creaBomberman();
		
		
	
	}
	
	

//	@Test
//	public void deBomba() {
//		Mapa mapa = new Mapa(2);
//		ArrayList<Bomberman> players =  mapa.getJugadores();
//		players.get(0).moverse("der", mapa);
//		
//		System.out.println(mapa);//borrar cuando terminen este test
//		Bomberman bomberman1 = new Bomberman(1,3);
//		Bomberman bomberman2 = new Bomberman(2,4);
//		Bloque tran = new Bloque("transitable",1,4);
//		Bloque piedra1 = new Bloque("piedra",1,6);
//		Bloque piedra2 = new Bloque("obstaculo",1,5);
//		Bloque piedra3 = new Bloque("piedra",1,2);
//		
//		mapa.setMatrizMapa(piedra1,1,6);
//		mapa.setMatrizMapa(piedra2,1,5);
//		mapa.setMatrizMapa(piedra3,1,2);
//		mapa.setMatrizMapa(bomberman2,2,4);
//		mapa.setMatrizMapa(tran, 1,4);//lo pongo para que siempre pueda poner una bomba ahi
//		System.out.println(mapa);
//		mapa.setMatrizMapa(bomberman1,1,3);//pongo un bomber en el mapa (recordar que la bomba tiene rango 3)
//		bomberman1.ponerBomba(mapa);
//	    
//		//testear: -desde la pos donde puse la bomba (1,4) fijarse si habia piedra en algun lado (dentro de su rango) la rompio y corroborar que no siguio rompiendo,
//		//si habia bomberman en algun lado y lo mato y le reinicio su pos.
//		//si los obstaculos y las paredes no se rompieron.
//		//si los obstaculos paran la llama de la bomba (testear que no muera el bomberman detras de un obstaculo).
//		
//		
//		
//		System.out.println(mapa);//borrar cuando terminen este test
//		
//	}
//	@Test
//	public void queNoMateBomberman() {//este testea que no muera el bomber si esta atras de un obstaculo y tambien que los obstaculos no se rompen
//		Mapa mapaTest = new Mapa();
//		mapaTest.creaBomberman();
//		Bomberman delJuego = (Bomberman)mapaTest.getPosicionMapa(1, 1);
//		delJuego.moverse(Moverse.DERECHA, mapaTest);
//		
//		Bomba BombaTest = new Bomba(3,2);
//		mapaTest.setMatrizMapa(BombaTest, 3, 2);
//		BombaTest.explotarBomba(mapaTest);
//		
//		assertEquals(1, delJuego.getPosX());//pos x del bomber
//		assertEquals(2, delJuego.getPosY());//pos y del bomber
//	}
	@Test
	public void queRompeYNoContinua() {//este testea que rompa las piedras correspondientes y no siga rompiendo si encuentra una
		Mapa mapa = new Mapa();
		mapa.creaBomberman();
		Bomba bomba = new Bomba(3,3);
		mapa.setMatrizMapa(bomba, 3, 3);
		mapa.setMatrizMapa(new Bloque("transitable",2,3), 2, 3); 
		mapa.setMatrizMapa(new Bloque("transitable",4,3), 4, 3); 
		mapa.setMatrizMapa(new Bloque("transitable",5,3), 5, 3); 
		
		mapa.setMatrizMapa(new Bloque("piedra",1,3), 1, 3); 
		mapa.setMatrizMapa(new Bloque("piedra",6,3), 6, 3); 
		mapa.setMatrizMapa(new Bloque("piedra",7,3), 7, 3); 
		mapa.setMatrizMapa(new Bloque("piedra",3,2), 3, 2); 
		mapa.setMatrizMapa(new Bloque("piedra",3,4), 3, 4); 
		mapa.setMatrizMapa(new Bloque("piedra",3,5), 3, 5); 
		System.out.println(mapa);
		bomba.explotarBomba(mapa);
		System.out.println(mapa);
		
		assertEquals("transitable", ((Bloque)mapa.getPosicionMapa(1, 3)).queTipo());
		assertEquals("transitable", ((Bloque)mapa.getPosicionMapa(3, 2)).queTipo());
		assertEquals("transitable", ((Bloque)mapa.getPosicionMapa(6, 3)).queTipo());
		assertEquals("piedra", ((Bloque)mapa.getPosicionMapa(7, 3)).queTipo());
		assertEquals("transitable", ((Bloque)mapa.getPosicionMapa(3, 4)).queTipo());
		assertEquals("piedra", ((Bloque)mapa.getPosicionMapa(3, 5)).queTipo());
	}
//	@Test
//	public void queBombaExplotaBomba() {
//		Mapa mapa = new Mapa();
//		mapa.creaBomberman();
//		Bomba bombaExplosiva = new Bomba(3,3);
//		mapa.setMatrizMapa(new Bomba (3, 1), 3,1);
//		mapa.setMatrizMapa(new Bomba (3, 5), 3, 5);
//		mapa.setMatrizMapa(new Bloque("transitable",3,4), 3, 4);
//		mapa.setMatrizMapa(new Bloque("piedra",3,2), 3, 2);
//		mapa.setMatrizMapa(new Bloque("piedra",4,5),4,5);
//		bombaExplosiva.explotarBomba(mapa);
//		
//		assertTrue(mapa.getPosicionMapa(3, 1) instanceof Bomba);
//		assertEquals("transitable", ((Bloque)mapa.getPosicionMapa(4, 5)).queTipo());
//	}
//	@Test
//	public void queMataBomberman() {
//		Mapa mapa = new Mapa();
//		mapa.creaBomberman();
//		Bomberman delJuego = (Bomberman)mapa.getPosicionMapa(1, 1);
//		delJuego.moverse(Moverse.DERECHA, mapa);
//		
//		Bomba bomba = new Bomba(1,3);
//		bomba.explotarBomba(mapa);
//		
//		assertTrue(mapa.getPosicionMapa(1, 1) instanceof Bomberman);
//		//assertEquals(1, delJuego.getCantMuertes());//no funca
//	}
}
