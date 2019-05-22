package controleur;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import modele.FigureColoree;
import modele.Point;

/*
 * @author Nosal Loïck
 * Classe modélisant des Traits
 */
public class Trait extends FigureColoree {
	
	/*
	 * abscisse du premier point du trait
	 */
	private int debx;
	/*
	 * ordonnee du premier point du trait
	 */
	private int deby;
	/*
	 * abscisse du dernier point du trait
	 */
	private int finx;
	/*
	 * ordonnee du dernier point du trait
	 */
	private int finy;
	/*
	 * couleur du trait
	 */
	private Color couleur;
	
	/*
	 * Constructeur
	 */
	public Trait(int x1, int y1, int x2, int y2, Color c) {
		this.debx = x1;
		this.deby = y1;
		this.finx = x2;
		this.finy = y2;
		this.couleur = c;
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
		g.drawLine(this.debx, deby, finx, finy);
		super.afficher(g);
	}
	
	@Override
	public void modifierPoints(ArrayList<Point> pts) {
		// TODO Auto-generated method stub
	}


	@Override
	public boolean estDedans(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	

}
