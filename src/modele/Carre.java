package modele;

import java.util.ArrayList;

/*
 * @author Nosal Loïck
 * Classe modélisant les Carrés
 */
public class Carre extends Rectangle{
	
	/*
	 * constructeur vide
	 */
	public Carre() {
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
		
		ArrayList<Point> rec = new ArrayList<Point>(2);
		
		if (pts.size()>1 && pts.size()<3){
			int x = 0;
			int y = 0;
			int diff = Math.abs(pts.get(0).rendreX() - pts.get(1).rendreX());
			
			//coin haut gauche/bas droite
			if (pts.get(0).rendreY() < pts.get(1).rendreY() && pts.get(0).rendreX() < pts.get(1).rendreX()){
				x = pts.get(0).rendreX() + diff;
				y = pts.get(0).rendreY() + diff;
			}
			//coin bas droite/haut gauche
			else if (pts.get(0).rendreY() >= pts.get(1).rendreY() && pts.get(0).rendreX() >= pts.get(1).rendreX()){
				x = pts.get(0).rendreX() - diff;
				y = pts.get(0).rendreY() - diff;
			}
			//coin haut droite/bas gauche
			else if ( pts.get(0).rendreY() < pts.get(1).rendreY() && pts.get(0).rendreX() > pts.get(1).rendreX()){
				x = pts.get(0).rendreX() - diff;
				y = pts.get(0).rendreY() + diff;
			}
			//coin bas gauche/haut droite
			else {
				x = pts.get(0).rendreX() + diff;
				y = pts.get(0).rendreY() - diff;
			}
			
			rec.add(pts.get(0));
			rec.add(new Point(x,y));
		}
		super.modifierPoints(rec);
	}
	
	@Override
	public void transformation(int dx, int dy, int indice) {
		ArrayList<Point> rec = new ArrayList<Point>(2);
	
		int i = 0;	
		
		for (Point p : tab_mem) {
			
			if (indice == i) {
			
				tab_mem.get(indice).modifierX(dx);
				tab_mem.get(indice).modifierY(dy);
				
				if (indice == 0) {
					
					rec.add(tab_mem.get(0));
					rec.add(tab_mem.get(2));
					
					
				}else if (indice == 1) {
					
					rec.add(tab_mem.get(1));
					rec.add(tab_mem.get(3));
					
					
				}else if (indice == 2) {
					rec.add(tab_mem.get(0));
					rec.add(tab_mem.get(2));		
					
						
				}else if (indice == 3) {
					rec.add(tab_mem.get(1));
					rec.add(tab_mem.get(3));
					
					
				}
			}
			i++;
		}
		modifierPoints(rec);

		
	}

}
