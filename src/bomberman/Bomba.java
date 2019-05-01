package bomberman;

public class Bomba extends Entidad{

	private int rango;
	private int tiempoDeEjecucion;
	
	public Bomba(int x, int y) {
		super(x,y);
		this.rango=1;
		this.tiempoDeEjecucion=3;		
	}
	
	
	public void explotarBomba(Mapa mapa) {
		boolean obstaculoArriba = false, obstaculoAbajo = false, obstaculoDerecha = false, obstaculoIzquierda = false;
		int i;
		for(i=0;i<this.rango;i++) 
		{
			if(mapa.getPosicionMapa(this.x+i, this.y) instanceof Bloque && !obstaculoDerecha)
				mapa.setPosicionMapa(this.x+i,this.y, null);
			else if(!obstaculoDerecha)
				obstaculoDerecha = true;
			
			if(mapa.getPosicionMapa(this.x-i, this.y) instanceof Bloque && !obstaculoIzquierda)
				mapa.setPosicionMapa(this.x-i,this.y, null);
			else if(!obstaculoIzquierda)
				obstaculoIzquierda = true;
			
			if(mapa.getPosicionMapa(this.x, this.y+i) instanceof Bloque && !obstaculoAbajo)
				mapa.setPosicionMapa(this.x,this.y+1, null);
			else if(!obstaculoAbajo)
				obstaculoAbajo = true;
			
			if(mapa.getPosicionMapa(this.x, this.y-i) instanceof Bloque && !obstaculoArriba)
				mapa.setPosicionMapa(this.x,this.y-1, null);
			else if(!obstaculoArriba)
				obstaculoArriba = true;
		}
	}
}
