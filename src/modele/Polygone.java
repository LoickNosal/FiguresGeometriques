package modele;

import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;

/*
 * Cette classe abstraite est la super classe de tous les polygones.
 * @author Loick Nosal
 */
public abstract class Polygone extends FigureColoree{
	
	/*
	 * Polygone du package jawa.awt 
	 */
	private Polygon p;
	
	/*
	 * constructeur vide
	 * Initialise le Polygone
	 */
	public Polygone() {
		super();
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
	
	@Override
	/*
	 * M�thode affichant un polygone (fait appel � fillPolygon de la classe Java Polygon).
	 */
	public void afficher(Graphics g) {
		g.setColor(this.couleur);
		g.fillPolygon(this.p);
		super.afficher(g);
	}
	
	@Override
	public int nbClics() {
		return this.p.npoints; //nb de points d'un polygon
	}
	

	@Override
	/*
	 * Cette m�thode retourne en r�sultat le nombre de points dont on a besoin, en g�n�ral, pour la saisie d'un polygone
	 */
	public abstract int nbPoints();

	@Override
	/*
	 *Cette m�thode modifie le polygone conform�ment 
	 *� un ensemble de points de saisie (ses nouveaux sommets).
	 */
	public void modifierPoints(ArrayList<Point> pts) {
		this.tab_mem = pts;
		if (this.tab_mem != null) {
			int[] ab = new int[super.tab_mem.size()];
			int[] or = new int[super.tab_mem.size()];
			int i = 0;
			for (Point p : super.tab_mem) {
				if (p != null) {
					ab[i] = p.rendreX();
					or[i] = p.rendreY();
				}	
				i++;
			}
			this.p = new Polygon(ab,or,super.tab_mem.size());
		}
		
	}
	
	
	/**
	 * v�rifie si le point de coordonn�es est dans le polygone
	 */
	public boolean estDans(int x, int y){
		return this.p.contains(new java.awt.Point(x, y));
	}
}
