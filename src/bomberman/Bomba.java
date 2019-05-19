package bomberman;

import java.util.HashMap;

public class Bomba extends Entidad {

	private int rango;
	private int tiempoDeEjecucion;

	public int getRango() {
		return rango;
	}

	public void setRango(int rango) {
		this.rango = rango;
	}

	public int getTiempoDeEjecucion() {
		return tiempoDeEjecucion;
	}

	public void setTiempoDeEjecucion(int tiempoDeEjecucion) {
		this.tiempoDeEjecucion = tiempoDeEjecucion;
	}

	public Bomba(int x, int y) {
		super(x, y);
		this.rango = 3;
		this.tiempoDeEjecucion = 3;
	}

	public void explotarBomba(Mapa mapa) {
			int deltas[][]= {{1,0},{0,1},{-1,0},{0,-1}};
			boolean validas[]= {false,false,false,false};
			int dx, dy;
			Bloque transit = new Bloque("transitable",this.getX(),this.getY());
			mapa.setMatrizMapa(transit, this.getX(), this.getY());//saco la bomba de la interfaz
			
			for(int i=0;i<=this.rango;i++) 
			{
				for(int j=0; j<deltas.length;j++) {
					dx=this.getX()+(deltas[j][0]);
					dy=this.getY()+(deltas[j][1]);
					
					if(validas[j]==false && mapa.getPosicionMapa(dx,dy).esBloque()) {
						if(((Bloque)mapa.getPosicionMapa(dx,dy)).queTipo()=="pared" ||
								((Bloque)mapa.getPosicionMapa(dx,dy)).queTipo()=="obstaculo") {
							validas[j]=true;
						}
						else if(((Bloque)mapa.getPosicionMapa(dx,dy)).queTipo()=="piedra") {
							Bloque transitable = new Bloque("transitable",dx,dy);
							mapa.setMatrizMapa(transitable, dx,dy);
							validas[j]=true;
						}	
					}				
					if(validas[j]==false && mapa.getPosicionMapa(dx,dy).esBomberman()) {
						Bomberman muerto = (Bomberman)mapa.getPosicionMapa(dx,dy);
						Bloque transitable = new Bloque("transitable",dx,dy);
						mapa.setMatrizMapa(transitable, dx,dy);
						muerto.muere(mapa);
					}
					if(i!=0 && validas[j]==false && mapa.getPosicionMapa(dx,dy).esBomba()) {
						Bomba encontrada = (Bomba)mapa.getPosicionMapa(dx,dy);
						encontrada.explotarBomba(mapa);
						validas[j]=true;
					}
				}
				deltas[0][0]+=1;
				deltas[1][1]+=1;
				deltas[2][0]-=1;
				deltas[3][1]-=1;
			}
	}

	@Override
	public String toString() {
		return "Bomba";
	}
	
	@Override
	public boolean esBloque() {
		return false;
	}
	@Override 
	public boolean esBomberman() {
		return false;
	}
	@Override 
	public boolean esBomba() {
		return true;
	}
}