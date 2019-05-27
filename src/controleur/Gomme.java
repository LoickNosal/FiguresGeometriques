package controleur;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import modele.DessinModele;
import modele.FigureColoree;

/**
 * Classe permettant de gommer des traits et des figures
 * @author Nosal Loïck
 */
public class Gomme implements MouseMotionListener, MouseListener{

	/**
	 * dessin sur lequel gommer
	 */
	private DessinModele dm;
	
	/**
	 * Abscisse d'un clic de souris.
	 */
	private int last_x;
	/**
	 * Ordonnée d'un clic de souris.
	 */
	private int last_y;
	
	/**
	 * Constructeur
	 * @param dessin modele surlequel gommer
	 */
	public Gomme(DessinModele dessin) {
		this.dm = dessin;
		this.last_x = 0;
		this.last_y = 0;

	}
	
	/**
	 * change les coordonnes quand on clique
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		this.last_x = e.getX();
		this.last_y = e.getY();
		
	}


	/**
	 * gomme quand on dragg la souris
	 */
	@Override
	public void mouseDragged(MouseEvent e) {		
		
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
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mouseMoved(MouseEvent e) {}
	
	

}
