package modele;

import java.awt.Graphics;

/*
 * Cette classe abstraite est la super classe de tous les polygones.
 * @author Loick Nosal
 */
public class Polygone extends FigureColoree{
	
	private Polygone p;
	
	
	public Polygone() {
		throw new Error("pas fait");
	}

	public void affiche(Graphics g) {
		throw new Error("pas fait");
	}
	
	public int nbClics() {
		throw new Error("pas fait");
	}
	
	public void modifierPoints(Point[] p) {
		throw new Error("pas fait");
	}

	@Override
	public int nbPoints() {
		// TODO Auto-generated method stub
		return 0;
	}
}
