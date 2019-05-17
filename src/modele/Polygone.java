package modele;

import java.awt.Graphics;
import java.util.ArrayList;

/*
 * Cette classe abstraite est la super classe de tous les polygones.
 * @author Loick Nosal
 */
public abstract class Polygone extends FigureColoree{
	
	private java.awt.Polygon p;
	
	
	public Polygone() {
		this.p = new  java.awt.Polygon();
	}

	/*
	 * Méthode affichant un polygone (fait appel à fillPolygon de la classe Java Polygon).
	 */
	public void affiche(Graphics g) {
		throw new Error("pas fait");
	}
	
	public int nbClics() {
		throw new Error("pas fait");
	}
	

	@Override
	/*
	 * Cette méthode retourne en résultat le nombre de points dont on a besoin, en général, pour la saisie d'un polygone
	 */
	public int nbPoints() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	/*
	 *Cette méthode modifie le polygone conformément à un ensemble de points de saisie (ses nouveaux sommets).
	 */
	public void modifierPoints(ArrayList<Point> pts) {
		// TODO Auto-generated method stub
		
	}
}
