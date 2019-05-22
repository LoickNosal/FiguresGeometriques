package controleur;

import java.awt.event.MouseListener;
import java.util.ArrayList;

import modele.FigureColoree;
import modele.Point;
import vue.VueDessin;

/*
 * Classe implemantant la creation de figures geometriques 
 * via des clics de souris.
 * @author Loick Nosal
 */
public class FabricantFigures implements MouseListener {

	/*
	 * Accumule le nombre de clics de souris.
	 */
	private int nb_points_cliques;
	/*
	 * figure en train d'etre dessinnee
	 */
	private FigureColoree figure_en_cours_de_fabrication;
	/*
	 * liste contenant des points crees a partir de clics de souris.
	 */
	private ArrayList<Point> points_cliques;

	/*
	 * Constructeur qui initialise la figure à construire.
	 * @param f figure à construire
	 */
	public FabricantFigures(FigureColoree f) {
		if (f != null) {	
			this.figure_en_cours_de_fabrication = f;
			this.nb_points_cliques = 0;
			this.points_cliques = new ArrayList<Point>();
		}

	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	/*
	 * Méthode implémentant la création d'une figure géométrique 
	 * via des clics de souris
	 */
	public void mousePressed(java.awt.event.MouseEvent e) {

		if (this.figure_en_cours_de_fabrication != null) {

			if (this.nb_points_cliques < this.figure_en_cours_de_fabrication.nbPoints()) {
				this.points_cliques.add(new Point(e.getX(), e.getY()));
				this.figure_en_cours_de_fabrication.modifierPoints(this.points_cliques);
				this.nb_points_cliques++;

			}

			if (this.nb_points_cliques == this.figure_en_cours_de_fabrication.nbClics()) {
				((VueDessin) e.getSource()).getDessin().ajoute(this.figure_en_cours_de_fabrication);
				((VueDessin) e.getSource()).repaint();
				((VueDessin) e.getSource()).removeMouseListener(this);
			}

		}


	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override

	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
