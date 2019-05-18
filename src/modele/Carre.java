package modele;

import java.util.ArrayList;

public class Carre extends Rectangle{
	
	
	public Carre() {
		super();
	}
	
	public int nbClics() {
		return 2;
	}
	
	public int nbPoints() {
		return 4;
	}
	
	public void modifierPoints(ArrayList<Point> pts) {
		ArrayList<Point> carre = new ArrayList<Point>(2);
		if (pts.size()>1){
			carre.add(pts.get(0));
			carre.add(new Point(pts.get(0).rendreX(), pts.get(1).rendreY()));
			pts.get(1).modifierX(carre.get(0).rendreX() + (int)carre.get(0).distance(carre.get(1)));
		}
			super.modifierPoints(pts);
	}

}
