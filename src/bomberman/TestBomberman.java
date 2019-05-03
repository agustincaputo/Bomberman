package bomberman;


import static org.junit.Assert.*;
import org.junit.Test;



public class TestBomberman {
	
	@Test
	public void TestPonerBomba(){
		Bomba bomba = new Bomba(2,1);
		assertEquals(2,bomba.getX());
		assertEquals(1,bomba.getY());
				
	};

}
