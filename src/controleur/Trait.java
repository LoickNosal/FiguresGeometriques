package controleur;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;

import modele.FigureColoree;
import modele.Point;

/**
 * @author Nosal Loïck
 * Classe modélisant des Traits
 */
public class Trait extends FigureColoree implements Serializable {
	
	/**
	 * abscisse du premier point du trait
	 */
	private int debx;
	/**
	 * ordonnee du premier point du trait
	 */
	private int deby;
	/**
	 * abscisse du dernier point du trait
	 */
	private int finx;
	/**
	 * ordonnee du dernier point du trait
	 */
	private int finy;
	/**
	 * couleur du trait
	 */
	private Color couleur;
	
	
	/**
	 * Constructeur
	 * @param x1 x de depart du trait
	 * @param y1 y de depart du trait
	 * @param x2 x de fin du trait
	 * @param y2 y de fin du trait
	 * @param c couleur du trait
	 * @param e epaisseur du trait
	 */
	public Trait(int x1, int y1, int x2, int y2, Color c, float e) {
		super(e);
		this.debx = x1;
		this.deby = y1;
		this.finx = x2;
		this.finy = y2;
		this.couleur = c;
		this.epaisseur = e;
	}

	/**
	 * clonage de trait impossible mais methode faite pour l'implémenter
	 * peut être plus tard
	 * @return trait cloné
	 */
	public Trait clone() {
		int x1 = this.debx;
		int y1 = this.deby;
		int x2 = this.finx;
		int y2 = this.finy;
		Color c = this.couleur;
		float e = this.epaisseur;
		Trait t = new Trait(x1, y1, x2, y2, c,e);
		return t;
		
		
	}

	public int getDebx() {
		return debx;
	}


	public int getDeby() {
		return deby;
	}


	public int getFinx() {
		return finx;
	}


	public int getFiny() {
		return finy;
	}


	public Color getCouleur() {
		return couleur;
	}


	public void setDebx(int debx) {
		this.debx = debx;
	}


	public void setDeby(int deby) {
		this.deby = deby;
	}


	public void setFinx(int finx) {
		this.finx = finx;
	}


	public void setFiny(int finy) {
		this.finy = finy;
	}


	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}


	@Override
	public int nbPoints() {
		return 2;
	}


	@Override
	public int nbClics() {
		return 2;
	}
	
	@Override
	public void afficher(Graphics g) {
		g.setColor(this.couleur);
		Graphics2D g2 = (Graphics2D)g;
		//permet de tracer des lines arrondis
		BasicStroke line = new BasicStroke(epaisseur,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);
		g2.setStroke(line);
		g2.drawLine(this.debx, deby, finx, finy);
		super.afficher(g);
	}
	
	@Override
	public void modifierPoints(ArrayList<Point> pts) {}

	@Override
	public boolean estDedans(int x, int y) {
		this.selected = false;
		boolean res = false;
		//utile uniquement pour gommer des traits
		if ((Math.pow((this.debx - x), 2) + Math.pow((this.deby - y), 2)) <= Math.pow(10,2)
				|| (Math.pow((this.finx - x), 2) + Math.pow((this.finy - y), 2)) <= Math.pow(10,2)) {
			res = true;
		}
		return res;
	}


	
	
	
	

}
