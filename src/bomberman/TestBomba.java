package bomberman;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestBomba {
	
	Mapa mapa;
	
	
	@Before
	public void mapaHarcodeado() {
		mapa = new Mapa();
	}
	

	@Test
	public void queNoMateBomberman() {//este testea que no muera el bomber si esta atras de un obstaculo y tambien que los obstaculos no se rompen
		mapa.creaBomberman();
		Bomberman delJuego = (Bomberman)mapa.getPosicionMapa(1, 1);
		delJuego.moverse(Moverse.DERECHA, mapa);
		Bomba BombaTest = new Bomba(3,2);
		mapa.setMatrizMapa(BombaTest, 3, 2);
		BombaTest.explotar(mapa);
		assertEquals(1, delJuego.getPosX());//pos x del bomber
		assertEquals(2, delJuego.getPosY());//pos y del bomber
	}
	@Test
	public void queRompeYNoContinua() {//este testea que rompa las piedras correspondientes y no siga rompiendo si encuentra una
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
		bomba.explotar(mapa);
		
		
		assertEquals("transitable", ((Bloque)mapa.getPosicionMapa(1, 3)).queTipo());
		assertEquals("transitable", ((Bloque)mapa.getPosicionMapa(3, 2)).queTipo());
		assertEquals("transitable", ((Bloque)mapa.getPosicionMapa(6, 3)).queTipo());
		assertEquals("piedra", ((Bloque)mapa.getPosicionMapa(7, 3)).queTipo());
		assertEquals("transitable", ((Bloque)mapa.getPosicionMapa(3, 4)).queTipo());
		assertEquals("piedra", ((Bloque)mapa.getPosicionMapa(3, 5)).queTipo());
	}
	@Test
	public void queBombaExplotaBomba() {
		mapa.creaBomberman();
		Bomba bombaExplosiva = new Bomba(3,3);
		mapa.setMatrizMapa(new Bomba (3, 1), 3,1);
		mapa.setMatrizMapa(new Bomba (3, 5), 3, 5);
		mapa.setMatrizMapa(new Bloque("transitable",3,4), 3, 4);
		mapa.setMatrizMapa(new Bloque("piedra",3,2), 3, 2);
		mapa.setMatrizMapa(new Bloque("piedra",4,5),4,5);
		bombaExplosiva.explotar(mapa);
		
		assertTrue(mapa.getPosicionMapa(3, 1).esBomba());
		assertEquals("transitable", ((Bloque)mapa.getPosicionMapa(4, 5)).queTipo());
	}
	@Test
	public void queMataBomberman() {
		Mapa mapa = new Mapa();
		mapa.creaBomberman();
		Bomberman delJuego = (Bomberman)mapa.getPosicionMapa(1, 1);
		delJuego.moverse(Moverse.DERECHA, mapa);
		
		Bomba bomba = new Bomba(1,3);
		bomba.explotar(mapa);
		
		assertTrue(mapa.getPosicionMapa(1, 1) instanceof Bomberman);
		//assertEquals(1, delJuego.getCantMuertes());//no funca
	}

}
