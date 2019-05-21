package controleur;

import java.awt.Color;

public class Trait {
	
	private int debx;
	private int deby;
	private int finx;
	private int finy;
	private Color couleur;
	
	
	public Trait(int x1, int y1, int x2, int y2, Color c) {
		this.debx = x1;
		this.deby = y1;
		this.finx = x2;
		this.finy = y2;
		this.couleur = c;
	}


	public int getDebx() {
		return debx;
	}


	public int getDeby() {
		return deby;
	}


	public int getFinx() {
		return finx;
	}


	public int getFiny() {
		return finy;
	}


	public Color getCouleur() {
		return couleur;
	}


	public void setDebx(int debx) {
		this.debx = debx;
	}


	public void setDeby(int deby) {
		this.deby = deby;
	}


	public void setFinx(int finx) {
		this.finx = finx;
	}


	public void setFiny(int finy) {
		this.finy = finy;
	}


	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}
	
	
	

}
