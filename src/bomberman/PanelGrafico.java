package bomberman;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelGrafico extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ImageIcon bomba;
	private ImageIcon bomberman;
	private ImageIcon obstaculo;
	private ImageIcon piedra;
	private Mapa mapa;
	private Bomberman jugador1;
	
	public PanelGrafico() {
		super();
		this.bomba = new ImageIcon();
		this.bomberman = new ImageIcon("src/bomberman/graficos/bomberman.gif");
		this.obstaculo = new ImageIcon("src/bomberman/graficos/obstaculo.jpg");
		this.piedra = new ImageIcon("src/bomberman/graficos/piedra.jpg");		
		this.mapa = new Mapa();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Entidad[][] matrizMapa = this.mapa.getMatrizMapa();
		this.jugador1 = new Bomberman(1,1);
		mapa.setMatrizMapa(this.jugador1,1,1);
		
		int i,j;
		
		for(i=0;i<matrizMapa.length;i++)
		{
			for(j=0;j<matrizMapa[0].length;j++)
			{
				if(matrizMapa[i][j].esBloque())
				{
					if(((Bloque)mapa.getPosicionMapa(i,j)).queTipo() == "pared" || ((Bloque)mapa.getPosicionMapa(i,j)).queTipo() == "obstaculo")
						g.drawImage(obstaculo.getImage(),i*40,j*40,40,40,null);					
					
					if(((Bloque)mapa.getPosicionMapa(i,j)).queTipo() == "piedra")
						g.drawImage(piedra.getImage(),i*40,j*40,40,40,null);
				}
				
				if(matrizMapa[i][j].esBomberman()) {
					g.drawImage(bomberman.getImage(),i*40,j*40,40,40,null);
				}
					
			}
		}
		
		/*g.drawImage(piedra.getImage(),0,0,40,40,null)
		g.drawImage(piedra.getImage(),0,40,40,40,null);
		g.drawImage(piedra.getImage(),0,80,40,40,null);
		g.drawImage(piedra.getImage(),0,120,40,40,null);
		g.drawImage(piedra.getImage(),0,160,40,40,null);
		g.drawImage(piedra.getImage(),0,200,40,40,null);
		g.drawImage(piedra.getImage(),0,240,40,40,null);
		g.drawImage(piedra.getImage(),0,280,40,40,null);
		g.drawImage(piedra.getImage(),0,320,40,40,null);
		g.drawImage(piedra.getImage(),0,360,40,40,null);
		g.drawImage(piedra.getImage(),0,400,40,40,null);
		g.drawImage(piedra.getImage(),0,440,40,40,null);
		g.drawImage(piedra.getImage(),0,480,40,40,null);
		g.drawImage(piedra.getImage(),0,520,40,40,null);
		g.drawImage(piedra.getImage(),0,560,40,40,null);
		g.drawImage(piedra.getImage(),0,600,40,40,null);
		g.drawImage(piedra.getImage(),0,640,40,40,null);
		
		g.drawImage(piedra.getImage(),640,0,40,40,null);
		g.drawImage(piedra.getImage(),640,40,40,40,null);
		g.drawImage(piedra.getImage(),640,80,40,40,null);
		g.drawImage(piedra.getImage(),640,120,40,40,null);
		g.drawImage(piedra.getImage(),640,160,40,40,null);
		g.drawImage(piedra.getImage(),640,200,40,40,null);
		g.drawImage(piedra.getImage(),640,240,40,40,null);
		g.drawImage(piedra.getImage(),640,280,40,40,null);
		g.drawImage(piedra.getImage(),640,320,40,40,null);
		g.drawImage(piedra.getImage(),640,360,40,40,null);
		g.drawImage(piedra.getImage(),640,400,40,40,null);
		g.drawImage(piedra.getImage(),640,440,40,40,null);
		g.drawImage(piedra.getImage(),640,480,40,40,null);
		g.drawImage(piedra.getImage(),640,520,40,40,null);
		g.drawImage(piedra.getImage(),640,560,40,40,null);
		g.drawImage(piedra.getImage(),640,600,40,40,null);
		g.drawImage(piedra.getImage(),640,640,40,40,null);
		
		
		g.drawImage(piedra.getImage(),40,0,40,40,null);
		g.drawImage(piedra.getImage(),80,0,40,40,null);
		g.drawImage(piedra.getImage(),120,0,40,40,null);
		g.drawImage(piedra.getImage(),160,0,40,40,null);
		g.drawImage(piedra.getImage(),200,0,40,40,null);
		g.drawImage(piedra.getImage(),240,0,40,40,null);
		g.drawImage(piedra.getImage(),280,0,40,40,null);
		g.drawImage(piedra.getImage(),320,0,40,40,null);
		g.drawImage(piedra.getImage(),360,0,40,40,null);
		g.drawImage(piedra.getImage(),400,0,40,40,null);
		g.drawImage(piedra.getImage(),440,0,40,40,null);
		g.drawImage(piedra.getImage(),480,0,40,40,null);
		g.drawImage(piedra.getImage(),520,0,40,40,null);
		g.drawImage(piedra.getImage(),560,0,40,40,null);
		g.drawImage(piedra.getImage(),600,0,40,40,null);
		g.drawImage(piedra.getImage(),640,0,40,40,null);
		
		
		g.drawImage(piedra.getImage(),40,640,40,40,null);
		g.drawImage(piedra.getImage(),80,640,40,40,null);
		g.drawImage(piedra.getImage(),120,640,40,40,null);
		g.drawImage(piedra.getImage(),160,640,40,40,null);
		g.drawImage(piedra.getImage(),200,640,40,40,null);
		g.drawImage(piedra.getImage(),240,640,40,40,null);
		g.drawImage(piedra.getImage(),280,640,40,40,null);
		g.drawImage(piedra.getImage(),320,640,40,40,null);
		g.drawImage(piedra.getImage(),360,640,40,40,null);
		g.drawImage(piedra.getImage(),400,640,40,40,null);
		g.drawImage(piedra.getImage(),440,640,40,40,null);
		g.drawImage(piedra.getImage(),480,640,40,40,null);
		g.drawImage(piedra.getImage(),520,640,40,40,null);
		g.drawImage(piedra.getImage(),560,640,40,40,null);
		g.drawImage(piedra.getImage(),600,640,40,40,null);		
		
		g.drawImage(piedra.getImage(),80,80,40,40,null);
		g.drawImage(piedra.getImage(),160,80,40,40,null);
		g.drawImage(piedra.getImage(),240,80,40,40,null);
		g.drawImage(piedra.getImage(),320,80,40,40,null);
		g.drawImage(piedra.getImage(),400,80,40,40,null);
		g.drawImage(piedra.getImage(),480,80,40,40,null);
		g.drawImage(piedra.getImage(),560,80,40,40,null);
		
		g.drawImage(piedra.getImage(),80,160,40,40,null);
		g.drawImage(piedra.getImage(),160,160,40,40,null);
		g.drawImage(piedra.getImage(),240,160,40,40,null);
		g.drawImage(piedra.getImage(),320,160,40,40,null);
		g.drawImage(piedra.getImage(),400,160,40,40,null);
		g.drawImage(piedra.getImage(),480,160,40,40,null);
		g.drawImage(piedra.getImage(),560,160,40,40,null);
		
		g.drawImage(piedra.getImage(),80,240,40,40,null);
		g.drawImage(piedra.getImage(),160,240,40,40,null);
		g.drawImage(piedra.getImage(),240,240,40,40,null);
		g.drawImage(piedra.getImage(),320,240,40,40,null);
		g.drawImage(piedra.getImage(),400,240,40,40,null);
		g.drawImage(piedra.getImage(),480,240,40,40,null);
		g.drawImage(piedra.getImage(),560,240,40,40,null);
				
		g.drawImage(piedra.getImage(),80,320,40,40,null);
		g.drawImage(piedra.getImage(),160,320,40,40,null);
		g.drawImage(piedra.getImage(),240,320,40,40,null);
		g.drawImage(piedra.getImage(),320,320,40,40,null);
		g.drawImage(piedra.getImage(),400,320,40,40,null);
		g.drawImage(piedra.getImage(),480,320,40,40,null);
		g.drawImage(piedra.getImage(),560,320,40,40,null);
		
		g.drawImage(piedra.getImage(),80,400,40,40,null);
		g.drawImage(piedra.getImage(),160,400,40,40,null);
		g.drawImage(piedra.getImage(),240,400,40,40,null);
		g.drawImage(piedra.getImage(),320,400,40,40,null);
		g.drawImage(piedra.getImage(),400,400,40,40,null);
		g.drawImage(piedra.getImage(),480,400,40,40,null);
		g.drawImage(piedra.getImage(),560,400,40,40,null);
		
		g.drawImage(piedra.getImage(),80,480,40,40,null);
		g.drawImage(piedra.getImage(),160,480,40,40,null);
		g.drawImage(piedra.getImage(),240,480,40,40,null);
		g.drawImage(piedra.getImage(),320,480,40,40,null);
		g.drawImage(piedra.getImage(),400,480,40,40,null);
		g.drawImage(piedra.getImage(),480,480,40,40,null);
		g.drawImage(piedra.getImage(),560,480,40,40,null);
		
		g.drawImage(piedra.getImage(),80,560,40,40,null);
		g.drawImage(piedra.getImage(),160,560,40,40,null);
		g.drawImage(piedra.getImage(),240,560,40,40,null);
		g.drawImage(piedra.getImage(),320,560,40,40,null);
		g.drawImage(piedra.getImage(),400,560,40,40,null);
		g.drawImage(piedra.getImage(),480,560,40,40,null);
		g.drawImage(piedra.getImage(),560,560,40,40,null);

		g.drawImage(ladrillo.getImage(),40,40,40,40,null);
		g.drawImage(ladrillo.getImage(),80,40,40,40,null);
		g.drawImage(ladrillo.getImage(),120,40,40,40,null);
		g.drawImage(ladrillo.getImage(),120,80,40,40,null);
		g.drawImage(ladrillo.getImage(),120,160,40,40,null);
		g.drawImage(ladrillo.getImage(),120,360,40,40,null);*/
	}

	public Bomberman getJugador1() {
		return jugador1;
	}

	public void setJugador1(Bomberman jugador1) {
		this.jugador1 = jugador1;
	}

	public Mapa getMapa() {
		return mapa;
	}

	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}
	
	
	
	
}
