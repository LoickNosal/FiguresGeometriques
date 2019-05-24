package modele;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;

/*
 * @author Nosal Lo�ck
 * figure geometrique Cercle
 */
public class Cercle extends ConiqueCentree implements Serializable{
	
	/*
	 * Rayon du cercle
	 */
	private double rayon;
	
	/*
	 * constructeur
	 */
	public Cercle() {
		super();
		this.rayon = 0;
	}
	
	public Cercle clone() {
		Cercle ce = new Cercle();
		double r = this.rayon;
		Color co = this.getColor();
		ce.changeCouleur(co);
		
		
		Point p1 = this.getListePoint().get(0).clone();
		Point p2 = this.getListePoint().get(1).clone();
		
		ce.tab_mem.add(p1);
		ce.tab_mem.add(p2);
		ce.modifierPoints(ce.getListePoint());
		return ce;
		
		
	}

	@Override
	public int nbPoints() {
		return 2;
	}

	@Override
	public int nbClics() {
		return 2;
	}

	public void setRayon(double r) {
		this.rayon = r;
	}
	
	@Override
	public void modifierPoints(ArrayList<Point> pts) {
		ArrayList<Point> p = new ArrayList<Point>(2);
		if (pts.size()==2){
			p.add(pts.get(0)); //centre
			p.add(pts.get(1)); //deuxieme point
			
			this.centre = pts.get(0);
			this.rayon = pts.get(0).distance(pts.get(1));
			
		}
		tab_mem=p;

		
	}

	@Override
	public boolean estDedans(int x, int y) {
		boolean appartient = false;
		//formule cercle x� + y� = R�
		
		if ((Math.pow((x - this.centre.rendreX()), 2) + Math.pow((y - this.centre.rendreY()), 2)) <= Math.pow(this.rayon,2)) {
			appartient = true;
		}
		return appartient;
	}
	
	@Override
	public void afficher(Graphics g){
		int xcoinhautgauche = this.centre.rendreX() - (int) rayon;
		int ycoinhautgauche = this.centre.rendreY() - (int) rayon;
		int xcoinbasdroite = (int) rayon*2;
		int ycoinbasdroite = (int) rayon*2;
		g.setColor(this.couleur);
		g.fillOval(xcoinhautgauche,ycoinhautgauche,xcoinbasdroite,ycoinbasdroite);
		super.afficher(g);
	
	}
	
	@Override
	public void translation(int x, int y) {
		super.translation(x, y);
	}
	
	@Override
	public void transformation(int dx, int dy, int indice) {
		super.transformation(dx, dy, indice);
	}

	
}
