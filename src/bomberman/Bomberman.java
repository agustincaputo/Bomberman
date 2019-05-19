package bomberman;

import java.nio.channels.InterruptedByTimeoutException;

public class Bomberman extends Entidad{
	
	private boolean vivo;
	private int velocidad;
	private int puntos;
	private int cantMuertes;
	private int cantBombas;	
	private int posX=0;
	private int posY=0;
	
	

	public Bomberman(int x , int y ) {
		super(x,y);
		this.vivo = true;
		this.velocidad=1;
		this.puntos=0;
		this.cantMuertes=0;
		this.cantBombas=1;
		this.posX=x;
		this.posY=y;
	}
	
	public boolean isVivo() {
		return vivo;
	}

	@Override
	public String toString() {
		return "Bomberman";
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

	public Bomba ponerBomba(Mapa mapa) {
		if(mapa.esTransitable(posX, posY+1)) {
			Bomba nueva = new Bomba(posX,posY+1);//aca la ubico en el mapa (en el mismo lugar que el bomberman)	
			mapa.setMatrizMapa(nueva, posX, posY+1);//la muestro en la interfaz
		
			nueva.explotarBomba(mapa);
			return nueva;	
		}
		return null;
	}
	
	
	public void moverse(Moverse mov, Mapa mapa) {
		int dY = mov.getParametroY();
		int dX = mov.getParametroX();
		//hola
	
		if(mapa.esTransitable(this.posX+dX,this.posY+dY)) {
			Bloque transitable = new Bloque("transitable", posX, posY);
			mapa.setMatrizMapa(transitable,posX,posY);
			this.posY+=dY;
			this.posX+=dX;
			mapa.setMatrizMapa(this, posX, posY);
			}
		}	
	
	
	public void muere(Mapa mapa) {
		this.cantMuertes+=1;
		this.posX=this.getX();
		this.posY=this.getY();
		mapa.setMatrizMapa(this, posX, posY);
	}
	
	@Override
	public boolean esBloque() {
		return false;
	}
	@Override 
	public boolean esBomberman() {
		return true;
	}
	@Override 
	public boolean esBomba() {
		return false;
	}
	
}
