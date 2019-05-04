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
			boolean obstaculoArriba = false, obstaculoAbajo = false, obstaculoDerecha = false, obstaculoIzquierda = false;
			int i;
			Bloque transit = new Bloque("transitable",this.getX(),this.getY());
			mapa.setMatrizMapa(transit, this.getX(), this.getY());//saco la bomba de la interfaz
			
			
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
//	public void explotarBomba2(Mapa mapa) {
//		Entidad entEncontrada;
//		final int direccion[] = {-1,0,1,0};
//		HashMap<String, Integer> rangoMap = new HashMap<String, Integer>();
//		rangoMap.put("01", this.rango);
//		rangoMap.put("-10", this.rango);
//		rangoMap.put("0-1", this.rango);
//		rangoMap.put("10", this.rango);
//		int rangoAnt;
//		String key;
//		
//		// Elimina la bomba
//		mapa.setMatrizMapa(new Bloque("transitable", this.getX(), this.getY()), this.getX(), this.getY());
//		
//		/*
//		 * Primer for: Recorre la totalidad del rango incial de la bomba
//		 * Segundo for: Recorre en las cuatro direcciones
//		 * if: 	Si encuentra un Bloque no transitable (piedra, obstaculo, pared, etc),
//		 * 		el rango se detiene en ese lugar (cualquiera de esos frena la explosion)
//		 * 		y se guarda en el HashMap rangoMap.
//		 */
//		for(int iRango=0;iRango<=rango;iRango++) {
//			for (int iDir = 0; iDir < direccion.length; iDir++) {
//				entEncontrada = mapa.getPosicionMapa(this.getX()+direccion[iDir], this.getY()+direccion[(iDir+1)%4]);
//				if(		entEncontrada instanceof Bloque && 
//						((Bloque)entEncontrada).queTipo()!="transitable") {
//					key = Integer.toString(direccion[iDir])+Integer.toString(direccion[(iDir+1)%4]);
//					rangoAnt = rangoMap.get(key);
//					if(iRango<rangoAnt)
//						rangoMap.put(Integer.toString(direccion[iDir])+Integer.toString(direccion[(iDir+1)%4]),iRango);
//				}
//			}
//		}
//		/*
//		 * Una vez que se obtiene la totalidad del rango para todas las direcciones,
//		 * se recorre ahora de manera inversa: para tal direccion, en su rango total.
//		 * A medida que avanza va "explotando" todo a su manera.
//		 */
//		for(int iDir = 0; iDir < direccion.length; iDir++) {
//			key = Integer.toString(direccion[iDir])+Integer.toString(direccion[(iDir+1)%4]);
//			for(int iRango=0;iRango<=rangoMap.get(key);iRango++) {
//				entEncontrada = mapa.getPosicionMapa(this.getX()+direccion[iDir%4], this.getY()+direccion[(iDir+1)%4]);
//				if(entEncontrada instanceof Bomberman) {
//					((Bomberman)entEncontrada).muere(mapa);
//				}
//				if(iRango!=0 && entEncontrada instanceof Bomba) {
//					((Bomba)entEncontrada).explotarBomba2(mapa);
//				}
//				if( entEncontrada instanceof Bloque &&
//					((Bloque)entEncontrada).queTipo()=="piedra") {
//					((Bloque)entEncontrada).explotarPiedra();
//				}
//			}
//		}
//	}
	@Override
	public String toString() {
		return "Bomba";
	}
}
