package modele;

import java.awt.Polygon;
import java.util.ArrayList;
/*
 * @author Nosal Loïck
 * Classe modélisant les Rectangles
 */
public class Rectangle extends Quadrilatere{

	
	/*
	 * constructeur vide
	 */
	public Rectangle() {
		super();
	}
	
	@Override
	public int nbClics() {
		return 2;
	}
	@Override
	public int nbPoints() {
		return 4;
	}
	@Override
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
	public void translation(int x, int y) {	
		for(Point p : this.tab_mem) {
			p.translation(x, y);
		}
		super.modifierPoints(this.tab_mem);
	}

	
}
