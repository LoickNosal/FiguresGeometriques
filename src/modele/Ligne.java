package modele;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Vector;

public class Ligne extends FigureColoree {

	@Override
	public FigureColoree clone() {
		Ligne l = new Ligne();
		boolean creux = false;
		Color c = this.getColor();
		l.changeCouleur(c);
		
		Point p1 = this.getListePoint().get(0).clone();
		Point p2 = this.getListePoint().get(1).clone();
		
		l.tab_mem.add(p1);
		l.tab_mem.add(p2);
	
		l.modifierPoints(l.getListePoint());
		l.setFigureCreuse(creux);
		return l;
	}

	@Override
	public int nbPoints() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int nbClics() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public void modifierPoints(ArrayList<Point> pts) {
		tab_mem = pts;
	}
	
	@Override
	public void afficher(Graphics g) {
		int x1 = this.getListePoint().get(0).rendreX();
		int y1 = this.getListePoint().get(0).rendreY();
		int x2 = this.getListePoint().get(1).rendreX();
		int y2 = this.getListePoint().get(1).rendreY();
		g.drawLine(x1, y1, x2, y2);
		super.afficher(g);
	}

	@Override
	public boolean estDedans(int x, int y) {
		//Methode tr�s peu pr�cise utilisant des intervalles
		//car calcul de vecteur impr�cis
		boolean res = false;
		int x1 = this.getListePoint().get(0).rendreX();
		int y1 = this.getListePoint().get(0).rendreY();
		int x2 = this.getListePoint().get(1).rendreX();
		int y2 = this.getListePoint().get(1).rendreY();
		Point vecteurAB = new Point(x2-x1, y2-y1);
		Point vecteurAC = new Point(x-x1, y-y1);
//		System.out.println((vecteurAB.rendreX() * vecteurAC.rendreY())
//				- (vecteurAB.rendreY() * vecteurAC.rendreX()) );
		double k,k2;
		if ((vecteurAB.rendreX() * vecteurAC.rendreY())
				- (vecteurAB.rendreY() * vecteurAC.rendreX()) <= 1000
				&& (vecteurAB.rendreX() * vecteurAC.rendreY())
				- (vecteurAB.rendreY() * vecteurAC.rendreX()) >= -1000) {
			if (vecteurAC.rendreX() != 0 && vecteurAC.rendreY() != 0) {
				k = (double)(vecteurAB.rendreX()/vecteurAC.rendreX());
				k2 = (double)(vecteurAB.rendreY()/vecteurAC.rendreY());
				System.out.println(k);
				System.out.println(k2);
				if (k>0 || k2>0) {
					res = true;
				}
			}
			
			
			
		}
		return res;
	}

}
