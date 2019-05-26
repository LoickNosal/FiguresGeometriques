package modele;

import java.awt.Graphics;
import java.util.ArrayList;

public class Ligne extends FigureColoree {

	@Override
	public FigureColoree clone() {
		// TODO Auto-generated method stub
		return null;
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
		boolean res = false;
		int x1 = this.getListePoint().get(0).rendreX();
		int y1 = this.getListePoint().get(0).rendreY();
		int x2 = this.getListePoint().get(1).rendreX();
		int y2 = this.getListePoint().get(1).rendreY();
		
		if ((x2-x1)/(y2-y1) == (x-x1)/(y-y1)) {
			  if( x<=x2 && x>=x1) {
				  res = true;
			  }
		return res;
	}

}
