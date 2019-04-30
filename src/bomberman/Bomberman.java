package bomberman;

public class Bomberman extends Entidad{
	
	private boolean vivo;
	private int velocidad;
	private int puntos;
	private int cantMuertes;
	private int cantBombas;	
	private int posX=0;
	private int posY=0;

	public boolean isVivo() {
		return vivo;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getCantMuertes() {
		return cantMuertes;
	}

	public void setCantMuertes(int cantMuertes) {
		this.cantMuertes = cantMuertes;
	}

	public int getCantBombas() {
		return cantBombas;
	}

	public void setCantBombas(int cantBombas) {
		this.cantBombas = cantBombas;
	}

	public Bomberman(int x , int y ) {
		super(x,y);
		this.vivo = true;
		this.velocidad=1;
		this.puntos=0;
		this.cantMuertes=0;
		this.cantBombas=1;
	}
	
	public void moverse(int direccion) {
		
	}
	
	public Bomba ponerBomba(int x, int y) {
		Bomba nueva = new Bomba(x,y);		
		return nueva;		
	}

}
