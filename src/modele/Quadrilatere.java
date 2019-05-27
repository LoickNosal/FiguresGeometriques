package modele;

import java.awt.Color;
import java.io.Serializable;

/**
 * classe qui modélise un quadrilatere
 * @author Loick Nosal
 */
public class Quadrilatere extends Polygone implements Serializable{
	
	
	/**
	 * constructeur vide
	 */
	public Quadrilatere(float e) {
		super(e);
	}
	
	/**
	 * permet de cloner un quadrilatere
	 */
	public Quadrilatere clone() {
		Quadrilatere qu = new Quadrilatere(this.epaisseur);

		Color c = this.getColor();
		qu.changeCouleur(c);
		boolean creux = this.FigureCreuse;
		
		Point p1 = this.getListePoint().get(0).clone();
		Point p2 = this.getListePoint().get(1).clone();
		Point p3 = this.getListePoint().get(2).clone();
		Point p4 = this.getListePoint().get(3).clone();
		
		qu.tab_mem.add(p1);
		qu.tab_mem.add(p2);
		qu.tab_mem.add(p3);
		qu.tab_mem.add(p4);
		qu.modifierPoints(qu.getListePoint());
		qu.setFigureCreuse(creux);
		
		return qu;
	}
	
	@Override
	/**
	 * Cette méthode retourne en résultat le nombre de points 
	 * de mémorisation d'un quadrilatère
	 */
	public int nbPoints() {
		return 4;
	}
	
	@Override
	public int nbClics() {
		return 4;
	}
}
