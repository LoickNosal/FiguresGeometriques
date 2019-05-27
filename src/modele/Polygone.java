package modele;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Cette classe abstraite est la super classe de tous les polygones.
 * @author Loick Nosal
 */
public abstract class Polygone extends FigureColoree implements Serializable{
	
	/**
	 * Polygone du package jawa.awt 
	 */
	private Polygon p;
	
	/**
	 * constructeur vide
	 * Initialise le Polygone
	 */
	public Polygone(float e) {
		super(e);
		int[] ab = new int[super.tab_mem.size()];
		int[] or = new int[super.tab_mem.size()];
		int i = 0;
		for (Point p : super.tab_mem) {
			ab[i] = p.rendreX();
			or[i] = p.rendreY();
			i++;
		}
		this.p = new Polygon(ab,or,super.tab_mem.size());

	}
	
	/**
	 * methode abstraite qui va permettre de cloner les polygone
	 */
	public abstract Polygone clone();
	
	
	@Override
	/**
	 * Méthode affichant un polygone (fait appel à fillPolygon de la classe Java Polygon).
	 * @param g Graphics sur lequel afficher
	 */
	public void afficher(Graphics g) {
		g.setColor(this.couleur);
		if (FigureCreuse == true) {
			Graphics2D g2 = (Graphics2D)g;
			BasicStroke line = new BasicStroke(this.epaisseur);
			g2.setStroke(line);
			g.drawPolygon(this.p);
		}else {
			g.fillPolygon(this.p);
		}
		super.afficher(g);
		
	}
	
	@Override
	/**
	 * Cette méthode retourne en résultat le nombre de points dont on a besoin, en général, pour la saisie d'un polygone
	 */
	public int nbClics() {
		return this.p.npoints; //nb de points d'un polygon
	}
	

	@Override
	/**
	 * Cette méthode retourne en résultat le nombre de points dont on a besoin, en général, pour la saisie d'un polygone
	 */
	public abstract int nbPoints();

	@Override
	/**
	 *Cette méthode modifie le polygone conformément 
	 *à un ensemble de points de saisie (ses nouveaux sommets).
	 *@param pts nouvelle liste de point du polygone
	 */
	public void modifierPoints(ArrayList<Point> pts) {
		this.tab_mem = pts;
		if (this.tab_mem != null) {
			int[] ab = new int[this.tab_mem.size()];
			int[] or = new int[this.tab_mem.size()];
			int i = 0;
			for (Point p : this.tab_mem) {
				if (p != null) {
					ab[i] = p.rendreX();
					or[i] = p.rendreY();
				}	
				i++;
			}
			this.p = new Polygon(ab,or,this.tab_mem.size());
		}
		
	}
	
	@Override
	/**
	 * Cette méthode retourne vrai si le point dont les coordonnées sont passées en paramètre se trouve à l'intérieur du polygone.
	 * @param x coordonnee x du point
	 * @param y coordonnee y du point 
	 */
	public boolean estDedans(int x, int y){
		return this.p.contains(new java.awt.Point(x, y));
	}
}
