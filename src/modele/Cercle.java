package modele;

import java.awt.Graphics;
import java.util.ArrayList;

public class Cercle extends ConiqueCentree{
	
	private double rayon;
	
	public Cercle() {
		super();
		this.rayon = 0;
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
		// TODO Auto-generated method stub
		return false;
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

	}
	
	@Override
	public void transformation(int dx, int dy, int indice) {
		
	}

	
}
