package bomberman;

public class Bloque extends Entidad{
	
	private String tipoBloque;

	public Bloque(String tipo,int x, int y) {
		super(x,y);
		this.tipoBloque=tipo;		
	}

	@Override
	public String toString() {
		return tipoBloque;
	}
	
	public String queTipo() {
		return this.tipoBloque;
	}
	
	public void explotarPiedra() {
		this.tipoBloque="transitable";
	}
	
	@Override
	public boolean esBloque() {
		return true;
	}
	@Override 
	public boolean esBomberman() {
		return false;
	}
	@Override 
	public boolean esBomba() {
		return false;
	}
	
}