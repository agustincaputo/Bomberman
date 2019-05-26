package bomberman;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelGrafico contentPane;

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 628);
		contentPane = new PanelGrafico();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(new Color(79, 160, 2));
		setContentPane(contentPane);
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				setMovimiento(arg0);
			}
			
		});
	}
	
	public void setMovimiento(KeyEvent evento) {
		if(evento.getKeyCode() == KeyEvent.VK_LEFT) {
			contentPane.getJugador1().moverse(Moverse.IZQUIERDA, contentPane.getMapa());
		}
		
		if(evento.getKeyCode() == KeyEvent.VK_RIGHT) {
			contentPane.getJugador1().moverse(Moverse.DERECHA, contentPane.getMapa());
		}
		
		if(evento.getKeyCode() == KeyEvent.VK_UP) {
			contentPane.getJugador1().moverse(Moverse.ARRIBA, contentPane.getMapa());
		}
		
		if(evento.getKeyCode() == KeyEvent.VK_DOWN) {
			contentPane.getJugador1().moverse(Moverse.ABAJO, contentPane.getMapa());
		}
		
		if(evento.getKeyCode() == KeyEvent.VK_B) {
		}
		repaint();
		
	}

}
