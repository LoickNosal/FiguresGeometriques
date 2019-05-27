package modele;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;

import controleur.Trait;

/*
 * Cette classe abstraite représente les figures 
 * que l'on peut dessiner.
 *  @author Loick Nosal
 */
public abstract class FigureColoree implements Serializable{
	/*
	 * Constante definissant la taille des carres 
	 * de selection.
	 */
	protected static final int TAILLE_CARRE_SELECTION = 10;
	/*
	 * Constante définissant 
	 * la taille de la périphérie des carrés de sélection.
	 */
	protected static final int PERIPHERIE_CARRE_SELECTION = 10;
	/*
	 * Attribut booleen indiquant si la figure est
	 * selectionnee (son affichage est alors different).
	 */
	protected boolean selected;
	/*
	 * Attribut de type Color donnant la couleur de remplissage.
	 */
	protected Color couleur;
	/*
	 * Liste des points de memorisation de la figure.
	 */
	protected ArrayList<Point> tab_mem;
	
	protected boolean FigureCreuse;
	
	protected float epaisseur;
	
	/*
	 * constructeur vide qui initialise les attributs
	 */
	public FigureColoree(float ep) {
		this.selected = false;
		this.couleur = Color.black;
		this.tab_mem = new ArrayList<Point>();
		this.FigureCreuse = false;
		this.epaisseur = ep;

	}
	public void setFigureCreuse(boolean creuse) {
		this.FigureCreuse = creuse;
	}
	
	public void setEpaisseur(float e) {
		this.epaisseur = e;
	}
	
	public abstract FigureColoree clone();
	
	
	public ArrayList<Point> getListePoint(){
		return this.tab_mem;
	}
	/*
	 * permet de savoir si une figure est selectionne
	 */
	public boolean isSelected() {
		return this.selected;
	}
	/*
	 * Methode abstraite qui retourne le nombre de points de memorisation.
	 */
	public abstract int nbPoints();
	
	/*
	 * Methode abstraite qui retourne le nombre de clics 
	 * de souris necessaires a la construction d'une figure geometrique.
	 */
	public abstract int nbClics();
	
	/*
	 * Methode abstraite qui permet de modifier les points
	 *  de memorisation a partir de points de saisie.
	 */
	public abstract void modifierPoints(ArrayList<Point> pts);
	
	/**
	 * permet de savoir si les le Point(x,y) et dans la figure
	 */
	public abstract boolean estDedans(int x, int y);

	/*
	 * methode qui permet d'afficher une figure Coloree, et d'afficher
	 * les carres de selections si la figure est selectionnes
	 */
	public void afficher(Graphics g) {
	
		if (this.selected == true) {
			Graphics2D g2 = (Graphics2D)g;
			BasicStroke line = new BasicStroke(1.0f); //epaisseur des carre de selection
			g2.setStroke(line);
			for (Point p : tab_mem) {
				int ab = (int) (p.rendreX() - ((TAILLE_CARRE_SELECTION + epaisseur)/2));
				int or = (int) (p.rendreY() - ((TAILLE_CARRE_SELECTION + epaisseur) /2));
				int taille = (int) (TAILLE_CARRE_SELECTION + epaisseur);
				g.setColor(Color.gray);
				g.drawRect(ab, or, taille, taille);

			}
		}
	}
	/*
	 * indique que la figure est selectione
	 */
	public void selectionne() {
		if (this instanceof Trait) {
			this.selected = false;
		}else {
			this.selected = true;
		}
		
	}
	/*
	 * indique que la figure est deselectione
	 */
	public void deSelectionne() {
		this.selected = false;
	}
	/*
	 * changer la couleur de la figure
	 */
	public void changeCouleur(Color c) {
		this.couleur = c;
	}
	
	/**
	 * methode qui permet de deplacer la figure
	 * @param dx nouveau x
	 * @param dy nouveau y
	 */
	public void translation(int x, int y) {
		
		for(Point p : this.tab_mem) {
			p.translation(x, y);
		}
		this.modifierPoints(this.tab_mem);
	}
	
	/**
	 * methode qui permet de transformer la figure
	 * @param dx nouveau x du coin
	 * @param dy nouveau y du coin
	 * @param indice indice du coin à modifier
	 */
	public void transformation(int dx, int dy, int indice) {
		this.tab_mem.get(indice).modifierX(dx);
		this.tab_mem.get(indice).modifierY(dy);
		this.modifierPoints(this.tab_mem);
		
	}

	public Color getColor() {
		return this.couleur;
	}
	/*
	 * Méthode qui détecte un point 
	 * se trouvant près d'un carré de séléction.
	 */
	public int carreDeSelection(int x, int y) {
		Point p = new Point(x,y);
		int indice = -1;
		for (Point point : this.tab_mem) {
			indice += 1;
			if (p.distance(point) <= PERIPHERIE_CARRE_SELECTION + (this.epaisseur/2)) {
				return indice;
			}
		}
		return -1;
		
		
		

		
	}

}
