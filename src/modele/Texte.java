package modele;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Texte extends FigureColoree{
	
	private String texte;
	private Color couleur;
	private int posX;
	private int posY;
	private int taille;

	public Texte(float ep,String t, Color c, int x, int y,int ta) {
		super(ep);
		this.texte = t;
		this.couleur = c;
		this.posX = x;
		this.posY = y;
		this.taille = ta;
		
	}
	
	public void setTexte(String s) {
		this.texte = s;
	}

	@Override
	public FigureColoree clone() {
		return null;
	}

	@Override
	public int nbPoints() {
		return 0;
	}

	@Override
	public int nbClics() {
		return 0;
	}

	public void afficher(Graphics g) {
		g.setColor(this.couleur);
		g.setFont(new Font("Ma Police",0,this.taille)); //permet de changer la taille de la police
		g.drawString(this.texte,this.posX,this.posY);
		super.afficher(g);
	}
	@Override
	public void modifierPoints(ArrayList<Point> pts) {}

	@Override
	public boolean estDedans(int x, int y) {
		boolean res = false;
		//pour gommer le texte
		if ((x>=this.posX && x<=this.posX+this.texte.length()*6+(this.taille *5) ) 
				&& (y>this.posY-10  && y<this.posY+10)) {
			res = true;
		}
		return res;
	}

}
