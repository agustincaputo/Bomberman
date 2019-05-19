package bomberman;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestBomberman {

	Mapa mapa;
	Bomberman bomber;
	
	@Before
	public void creaMapaHarcodeado() {
		mapa = new Mapa();
		mapa.creaBomberman();
		mapa.setMatrizMapa(new Bloque("piedra",1,3),1, 3);
		
	}
	
	@Test
	public void moverseDerecha() {
		bomber = (Bomberman)mapa.getPosicionMapa(1, 1);
		bomber.moverse(Moverse.DERECHA, mapa);
		assertTrue((mapa.getPosicionMapa(1, 2)).esBomberman());
	}
	@Test
	public void moverseIzquierda() {
		bomber = (Bomberman)mapa.getPosicionMapa(1, 1);
		bomber.moverse(Moverse.DERECHA, mapa);
		bomber.moverse(Moverse.IZQUIERDA, mapa);
		assertTrue((mapa.getPosicionMapa(1, 1)).esBomberman());
	}
	@Test
	public void moverseAbajo() {
		bomber = (Bomberman)mapa.getPosicionMapa(1, 1);
		bomber.moverse(Moverse.ABAJO, mapa);
		assertTrue((mapa.getPosicionMapa(2, 1)).esBomberman());
	}
	@Test
	public void moverseArriba() {
		bomber = (Bomberman)mapa.getPosicionMapa(1, 1);
		bomber.moverse(Moverse.ABAJO, mapa);
		bomber.moverse(Moverse.ARRIBA, mapa);
		assertTrue((mapa.getPosicionMapa(1, 1)).esBomberman());
	}
	@Test
	public void queNoAtraviesaParedes() {
		bomber = (Bomberman)mapa.getPosicionMapa(1, 1);
		bomber.moverse(Moverse.IZQUIERDA, mapa);
		bomber.moverse(Moverse.ARRIBA,mapa);
		assertTrue((mapa.getPosicionMapa(1, 1)).esBomberman());
	}
	@Test
	public void queNoAtraviesaPiedras() {
		bomber = (Bomberman)mapa.getPosicionMapa(1, 1);
		bomber.moverse(Moverse.DERECHA, mapa);
		bomber.moverse(Moverse.DERECHA, mapa);
		assertTrue(mapa.getPosicionMapa(1, 2).esBomberman());
	}
	@Test
	public void queNoAtraviesaObstaculos() {
		bomber = (Bomberman)mapa.getPosicionMapa(1, 1);
		bomber.moverse(Moverse.ABAJO, mapa);
		bomber.moverse(Moverse.DERECHA, mapa);
		assertTrue(mapa.getPosicionMapa(2, 1).esBomberman());
	}
	
	
	

}