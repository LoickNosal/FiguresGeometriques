package modele;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * @author Loïck
 * Modélise un texte sur le dessin
 */
public class Texte extends FigureColoree{
	
	/**
	 * contenu du texte
	 */
	private String texte;
	/**
	 * couleur du texte
	 */
	private Color couleur;
	/**
	 * position x de depart du texte
	 */
	private int posX;
	/**
	 * position y de depart du texte
	 */
	private int posY;
	/**
	 * taille du texte
	 */
	private int taille;

	/**
	 * constructeur
	 * @param ep non utilisé (appelle au super)
	 * @param t contenu du texte
	 * @param c couleur du texte
	 * @param x position x de depart du texte
	 * @param y position y de depart du texte
	 * @param ta taille du texte
	 */
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
		if ((x>=this.posX && x<=this.posX+this.texte.length()*6+(this.taille *4) ) 
				&& (y>this.posY-10  && y<this.posY+10)) {
			res = true;
		}
		return res;
	}

}
