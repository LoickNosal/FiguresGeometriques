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
		ArrayList<Point> rec = new ArrayList<Point>(2);
		
		if (pts.size()>1){
			
			rec.add(pts.get(0));
			
			int x = 0;
			int y = 0;
			
			int DiffX = pts.get(1).rendreX() - pts.get(0).rendreY();
			int DiffY = pts.get(1).rendreY() - pts.get(0).rendreY();
			
			if (DiffX > 0 && DiffY > 0) { //coin bas droite
				if (DiffX > DiffY) {
					x = pts.get(0).rendreX() + DiffY;
					y = pts.get(0).rendreY() + DiffY;
				}else {
					x = pts.get(0).rendreX() + DiffX;
					y = pts.get(0).rendreY() + DiffX;
				}
				
			}else if(DiffX <0 && DiffY > 0){ //coin bas gauche
				x = pts.get(0).rendreX() - DiffX;
				y = pts.get(0).rendreY() + DiffX;
			}else if(DiffX >= 0 && DiffY <= 0) { //coin haut droit
				x = pts.get(0).rendreX() + DiffX;
				y = pts.get(0).rendreY() - DiffX;
			}else if(DiffX <= 0 && DiffY <= 0) { //coin haut gauche
				x = pts.get(0).rendreX() - DiffY;
				y = pts.get(0).rendreY() - DiffY;
			}else if(DiffX == DiffY) {
				x = pts.get(1).rendreX();
				y = pts.get(1).rendreY();
			}
			
			rec.add(new Point(x,y));
			

			
		}
		super.modifierPoints(rec);
	}

}
