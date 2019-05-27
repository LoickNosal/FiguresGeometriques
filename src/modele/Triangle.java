package modele;

import java.awt.Color;
import java.io.Serializable;

/*
 * @author Nosal Lo�ck
 * Classe mod�lisant les triangles
 */
public class Triangle extends Polygone implements Serializable{

	/*
	 * Constructeur vide
	 */
	public Triangle(float e){
		super(e);
	}
	
	public Triangle clone() {
		Triangle tr = new Triangle(this.epaisseur);
		boolean creux = this.FigureCreuse;
		Color c = this.getColor();
		tr.changeCouleur(c);
		
		Point p1 = this.getListePoint().get(0).clone();
		Point p2 = this.getListePoint().get(1).clone();
		Point p3 = this.getListePoint().get(2).clone();

		
		tr.tab_mem.add(p1);
		tr.tab_mem.add(p2);
		tr.tab_mem.add(p3);		
		
		tr.modifierPoints(tr.getListePoint());
		tr.setFigureCreuse(creux);
		return tr;
	}
	
	
	@Override
	/*
	 * Cette m�thode retourne en r�sultat le nombre de points de m�morisation d'un triangle.
	 */
	public int nbPoints() {
		return 3;
	}
	
	@Override
	public int nbClics() {
		return 3;
	}
}
