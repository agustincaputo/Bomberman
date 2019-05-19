package bomberman;

public enum Moverse {
	ARRIBA(-1,0),
	ABAJO(1,0),
	DERECHA(0,1),
	IZQUIERDA(0,-1);
	
	private int parametroX;
	private int parametroY;
	
	private Moverse(int parametroX, int parametroY) {
		this.parametroX=parametroX;
		this.parametroY=parametroY;
	}

	public int getParametroX() {
		return parametroX;
	}

	public int getParametroY() {
		return parametroY;
	}

}