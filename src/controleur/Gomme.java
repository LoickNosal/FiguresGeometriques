package controleur;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.SwingUtilities;



import modele.DessinModele;
import modele.FigureColoree;
import vue.VueDessin;

public class Gomme implements MouseMotionListener, MouseListener{

	private Graphics g;
	private DessinModele dm;
	
	
	public Gomme(Graphics gr, DessinModele dessin) {
		this.g = gr;
		this.dm = dessin;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {

		
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
		this.g.drawOval(e.getX()-25, e.getY()-25, 50, 50);
		this.dm.majAffichage();
		
		if (SwingUtilities.isLeftMouseButton(e)) {
			int i = 0;
			ArrayList<Integer> listei = new ArrayList<Integer>();
			
			for (FigureColoree fg : this.dm.get_fg()) {
				if (fg.estDedans(e.getX(), e.getY())) {
					listei.add(i);
				
				}
				i++;				
			}
			for (Integer in : listei) {
				this.dm.effacerFigure(in);
				this.dm.majAffichage();
			}
			
			
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		
	}
	
	

}
