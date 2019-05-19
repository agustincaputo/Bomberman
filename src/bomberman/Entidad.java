package bomberman;

public abstract class Entidad  {
	private int x;
	private int y;
	
	public Entidad() {
		
	}
	public Entidad(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public boolean esBloque() {
		return true;
	}
	public boolean esBomba() {
		return true;
	}
	public boolean esBomberman() {
		return true;
	}
	


}