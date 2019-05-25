package controleur;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import modele.Cercle;
import modele.DessinModele;
import modele.FigureColoree;
import vue.VueDessin;

public class Gomme implements MouseMotionListener, MouseListener{

	private Graphics g;
	private DessinModele dm;
	/*
	 * Abscisse d'un clic de souris.
	 */
	private int last_x;
	/*
	 * Ordonnée d'un clic de souris.
	 */
	private int last_y;
	
	public Gomme(Graphics gr, DessinModele dessin) {
		this.g = gr;
		this.dm = dessin;
		this.last_x = 0;
		this.last_y = 0;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		this.last_x = e.getX();
		this.last_y = e.getY();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		this.g.setColor(Color.BLACK);
		this.g.drawOval(last_x-20, last_y-20, 40, 40);
		
		
		if (SwingUtilities.isLeftMouseButton(e)) {
			ArrayList<Integer> listei = new ArrayList<Integer>();
			
			for (FigureColoree fg : this.dm.get_fg()) {
				if (fg.estDedans(last_x, last_y)) {
					listei.add(this.dm.get_fg().indexOf(fg));	
				}			
			}
			for (Integer in : listei) {
				this.dm.effacerFigure(in);

			}

		}
		this.last_x = e.getX();
		this.last_y = e.getY();
		this.dm.majAffichage();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	
	

}
