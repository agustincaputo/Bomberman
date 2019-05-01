package bomberman;



public class Bomba extends Entidad{

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
		super(x,y);
		this.rango=1;
		this.tiempoDeEjecucion=3;		
	}
	
	
	public void explotarBomba(Mapa mapa) {
			boolean obstaculoArriba = false, obstaculoAbajo = false, obstaculoDerecha = false, obstaculoIzquierda = false;
			int i;
			for(i=0;i<this.rango;i++) 
			{
				//abajo:
				if(mapa.getPosicionMapa(this.getX()+i, this.getY()) instanceof Bloque  && !obstaculoAbajo) {
					if(((Bloque)mapa.getPosicionMapa(this.getX()+i, this.getY())).queTipo()=="pared" ||
							((Bloque)mapa.getPosicionMapa(this.getX()+i, this.getY())).queTipo()=="obstaculo") {
						obstaculoAbajo=true;
					}
					else if(((Bloque)mapa.getPosicionMapa(this.getX()+i, this.getY())).queTipo()=="piedra") {
						Bloque transitable = new Bloque("transitable",this.getX()+i,this.getY());
						mapa.setMatrizMapa(transitable, this.getX()+i, this.getY());
						obstaculoAbajo=true;
					}	
				}
				if(mapa.getPosicionMapa(this.getX()+i, this.getY()) instanceof Bomberman && !obstaculoAbajo) {
					Bomberman muerto = (Bomberman)mapa.getPosicionMapa(this.getX()+i, this.getY());
					muerto.muere();
					Bloque transitable = new Bloque("transitable",this.getX()+i,this.getY());
					mapa.setMatrizMapa(transitable, this.getX()+i, this.getY());
				}
				//termino abajo	
				//arriba:
				if(mapa.getPosicionMapa(this.getX()-i, this.getY()) instanceof Bloque  && !obstaculoArriba) {
					if(((Bloque)mapa.getPosicionMapa(this.getX()-i, this.getY())).queTipo()=="pared" ||
							((Bloque)mapa.getPosicionMapa(this.getX()-i, this.getY())).queTipo()=="obstaculo") {
						obstaculoArriba=true;
					}
					else if(((Bloque)mapa.getPosicionMapa(this.getX()-i, this.getY())).queTipo()=="piedra") {
						Bloque transitable = new Bloque("transitable",this.getX()-i,this.getY());
						mapa.setMatrizMapa(transitable, this.getX()-i, this.getY());
						obstaculoArriba=true;
					}	
				}
				if(mapa.getPosicionMapa(this.getX()-i, this.getY()) instanceof Bomberman && !obstaculoArriba) {
					Bomberman muerto = (Bomberman)mapa.getPosicionMapa(this.getX()-i, this.getY());
					muerto.muere();
					Bloque transitable = new Bloque("transitable",this.getX()-i,this.getY());
					mapa.setMatrizMapa(transitable, this.getX()-i, this.getY());
				}
				//termino arriba
				//derecha:
				if(mapa.getPosicionMapa(this.getX(), this.getY()+i) instanceof Bloque  && !obstaculoDerecha) {
					if(((Bloque)mapa.getPosicionMapa(this.getX(), this.getY()+i)).queTipo()=="pared" ||
							((Bloque)mapa.getPosicionMapa(this.getX(), this.getY()+i)).queTipo()=="obstaculo") {
						obstaculoDerecha=true;
					}
					else if(((Bloque)mapa.getPosicionMapa(this.getX(), this.getY()+i)).queTipo()=="piedra") {
						Bloque transitable = new Bloque("transitable",this.getX(),this.getY()+i);
						mapa.setMatrizMapa(transitable, this.getX(), this.getY()+i);
						obstaculoDerecha=true;
					}	
				}
				if(mapa.getPosicionMapa(this.getX(), this.getY()+i) instanceof Bomberman && !obstaculoDerecha) {
					Bomberman muerto = (Bomberman)mapa.getPosicionMapa(this.getX(), this.getY()+i);
					muerto.muere();
					Bloque transitable = new Bloque("transitable",this.getX(),this.getY()+i);
					mapa.setMatrizMapa(transitable, this.getX(), this.getY()+i);
				}
				//termina derecha
				//izquierda:
				if(mapa.getPosicionMapa(this.getX(), this.getY()-i) instanceof Bloque  && !obstaculoIzquierda) {
					if(((Bloque)mapa.getPosicionMapa(this.getX(), this.getY()-i)).queTipo()=="pared" ||
							((Bloque)mapa.getPosicionMapa(this.getX(), this.getY()-i)).queTipo()=="obstaculo") {
						obstaculoIzquierda=true;
					}
					else if(((Bloque)mapa.getPosicionMapa(this.getX(), this.getY()-i)).queTipo()=="piedra") {
						Bloque transitable = new Bloque("transitable",this.getX(),this.getY()-i);
						mapa.setMatrizMapa(transitable, this.getX(), this.getY()-i);
						obstaculoIzquierda=true;
					}	
				}
				if(mapa.getPosicionMapa(this.getX(), this.getY()-i) instanceof Bomberman && !obstaculoIzquierda) {
					Bomberman muerto = (Bomberman)mapa.getPosicionMapa(this.getX(), this.getY()-i);
					muerto.muere();
					Bloque transitable = new Bloque("transitable",this.getX(),this.getY()-i);
					mapa.setMatrizMapa(transitable, this.getX(), this.getY()-i);
				}
				//termina izquierda
		}
	}
}
