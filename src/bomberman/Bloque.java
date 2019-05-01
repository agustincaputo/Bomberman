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
}
