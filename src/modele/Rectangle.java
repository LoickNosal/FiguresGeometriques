package modele;

import java.awt.Polygon;
import java.io.Serializable;
import java.util.ArrayList;
/*
 * @author Nosal Lo�ck
 * Classe mod�lisant les Rectangles
 */
public class Rectangle extends Quadrilatere implements Serializable{

	
	/*
	 * constructeur vide
	 */
	public Rectangle() {
		super();
	}
	
	@Override
	/*
	 * Cette m�thode retourne en r�sultat le nombre de points dont on a besoin pour la saisie d'un rectangle.
	 */
	public int nbClics() {
		return 2;
	}
	@Override
	public int nbPoints() {
		return 4;
	}
	
	@Override
	/*
	 * Cette m�thode modifie le rectangle conform�ment � un ensemble de deux points de saisie.
	 */
	public void modifierPoints(ArrayList<Point> pts) {
		ArrayList<Point> rec = new ArrayList<Point>(4);
		if (pts.size()>1){
			rec.add(pts.get(0));
			rec.add(new Point(pts.get(0).rendreX(), pts.get(1).rendreY()));
			rec.add(pts.get(1));
			rec.add(new Point(pts.get(1).rendreX(), pts.get(0).rendreY()));
	
		}
		super.modifierPoints(rec);
		
	}
	
	@Override
	/*
	 * Cette m�thode permet d'effectuer une translation des coordon�es du rectangle
	 */
	public void translation(int x, int y) {	
		for(Point p : this.tab_mem) {
			p.translation(x, y);
		}
		super.modifierPoints(this.tab_mem);
	}
	
	/*
	 * Cette m�thode permet d'effectuer une transformation des coordonn�es des points de m�morisation du rectangle.
	 */
	public void transformation(int dx, int dy, int indice) {
		int i = 0;		
		for (Point p : tab_mem) {
			if (indice == i) {
				
				tab_mem.get(i).modifierX(dx);
				tab_mem.get(i).modifierY(dy);
				
				if (indice == 0) {
					tab_mem.get(1).modifierX(dx);
					tab_mem.get(3).modifierY(dy);
				}else if (indice == 1) {
					tab_mem.get(0).modifierX(dx);
					tab_mem.get(2).modifierY(dy);
				}else if (indice == 2) {
					tab_mem.get(3).modifierX(dx);
					tab_mem.get(1).modifierY(dy);
					
				}else if (indice == 3) {
					tab_mem.get(2).modifierX(dx);
					tab_mem.get(0).modifierY(dy);
				}

			}
			i++;
		}
		super.modifierPoints(this.tab_mem);
		
	}

	
}
