package modele;

import java.awt.Polygon;
import java.util.ArrayList;

public class Rectangle extends Quadrilatere{

	

	public Rectangle() {
		super();
	}
	
	public int nbClics() {
		return 2;
	}
	
	public int nbPoints() {
		return 4;
	}
	
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
		
	
}
