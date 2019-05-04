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
		this.rango=3;
		this.tiempoDeEjecucion=3;		
	}
	
	
	public void explotarBomba(Mapa mapa) {
			boolean obstaculoArriba = false, obstaculoAbajo = false, obstaculoDerecha = false, obstaculoIzquierda = false;
			int i;
			for(i=0;i<=this.rango;i++) 
			{
				//abajo:
				if(obstaculoAbajo==false && mapa.getPosicionMapa(this.getX()+i, this.getY()) instanceof Bloque) {
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
				if(obstaculoAbajo==false && mapa.getPosicionMapa(this.getX()+i, this.getY()) instanceof Bomberman) {
					Bomberman muerto = (Bomberman)mapa.getPosicionMapa(this.getX()+i, this.getY());
					Bloque transitable = new Bloque("transitable",this.getX()+i,this.getY());
					mapa.setMatrizMapa(transitable, this.getX()+i, this.getY());
					muerto.muere(mapa);
				}
				if(i!=0 && obstaculoAbajo==false && mapa.getPosicionMapa(this.getX()+i, this.getY()) instanceof Bomba) {
					Bomba encontrada = (Bomba)mapa.getPosicionMapa(this.getX()+i, this.getY());
					encontrada.explotarBomba(mapa);
					obstaculoAbajo=true;
				}
				//termino abajo	
				//arriba:
				if(obstaculoArriba==false && mapa.getPosicionMapa(this.getX()-i, this.getY()) instanceof Bloque) {
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
				if(obstaculoArriba==false && mapa.getPosicionMapa(this.getX()-i, this.getY()) instanceof Bomberman ) {
					Bomberman muerto = (Bomberman)mapa.getPosicionMapa(this.getX()-i, this.getY());
					Bloque transitable = new Bloque("transitable",this.getX()-i,this.getY());
					mapa.setMatrizMapa(transitable, this.getX()-i, this.getY());
					muerto.muere(mapa);
				}
				if(i!=0 && obstaculoArriba==false && mapa.getPosicionMapa(this.getX()-i, this.getY()) instanceof Bomba ) {
					Bomba encontrada = (Bomba)mapa.getPosicionMapa(this.getX()-i, this.getY());
					encontrada.explotarBomba(mapa);
					obstaculoArriba=true;
				}
				//termino arriba
				//derecha:
				if(obstaculoDerecha==false && mapa.getPosicionMapa(this.getX(), this.getY()+i) instanceof Bloque ) {
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
				if(obstaculoDerecha==false && mapa.getPosicionMapa(this.getX(), this.getY()+i) instanceof Bomberman) {
					Bomberman muerto = (Bomberman)mapa.getPosicionMapa(this.getX(), this.getY()+i);
					Bloque transitable = new Bloque("transitable",this.getX(),this.getY()+i);
					mapa.setMatrizMapa(transitable, this.getX(), this.getY()+i);
					muerto.muere(mapa);
				}
				if(i!=0 && obstaculoDerecha==false && mapa.getPosicionMapa(this.getX(), this.getY()+i) instanceof Bomba)  {
					Bomba encontrada = (Bomba)mapa.getPosicionMapa(this.getX(), this.getY()+i);
					encontrada.explotarBomba(mapa);
					obstaculoDerecha=true;
				}
				//termina derecha
				//izquierda:
				if(obstaculoIzquierda==false && mapa.getPosicionMapa(this.getX(), this.getY()-i) instanceof Bloque) {
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
				if(obstaculoIzquierda==false && mapa.getPosicionMapa(this.getX(), this.getY()-i) instanceof Bomberman) {
					Bomberman muerto = (Bomberman)mapa.getPosicionMapa(this.getX(), this.getY()-i);
					Bloque transitable = new Bloque("transitable",this.getX(),this.getY()-i);
					mapa.setMatrizMapa(transitable, this.getX(), this.getY()-i);
					muerto.muere(mapa);
				}
				if(i!=0 && obstaculoIzquierda==false && mapa.getPosicionMapa(this.getX(), this.getY()-i) instanceof Bomba) {
					Bomba encontrada = (Bomba)mapa.getPosicionMapa(this.getX(), this.getY()-i);
					encontrada.explotarBomba(mapa);
					obstaculoIzquierda=true;
				}
				//termina izquierda
		}
	}


	@Override
	public String toString() {
		return "Bomba";
	}
}
