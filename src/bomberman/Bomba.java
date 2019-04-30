package bomberman;

public class Bomba extends Entidad{

	private int rango;
	private int tiempoDeEjecucion;
	
	
	public Bomba(int x, int y) {
		super(x,y);
		this.rango=1;
		this.tiempoDeEjecucion=3;		
	}
}
