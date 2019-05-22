package modele;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/*
 * Cette classe abstraite repr�sente les figures 
 * que l'on peut dessiner.
 *  @author Loick Nosal
 */
public abstract class FigureColoree {
	/*
	 * Constante definissant la taille des carres 
	 * de selection.
	 */
	protected static final int TAILLE_CARRE_SELECTION = 10;
	/*
	 * Constante d�finissant 
	 * la taille de la p�riph�rie des carr�s de s�lection.
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
	
	/*
	 * constructeur vide qui initialise les attributs
	 */
	public FigureColoree() {
		this.selected = false;
		this.couleur = Color.black;
		this.tab_mem = new ArrayList<Point>();

	}
	
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

			for (Point p : tab_mem) {
				int ab = p.rendreX() - (TAILLE_CARRE_SELECTION/2);
				int or = p.rendreY() - (TAILLE_CARRE_SELECTION/2);
				g.setColor(Color.gray);
				g.drawRect(ab, or, TAILLE_CARRE_SELECTION, TAILLE_CARRE_SELECTION);

			}
		}
	}
	/*
	 * indique que la figure est selectione
	 */
	public void selectionne() {
		this.selected = true;
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
	 * @param indice indice du coin � modifier
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
	 * M�thode qui d�tecte un point 
	 * se trouvant pr�s d'un carr� de s�l�ction.
	 */
	public int carreDeSelection(int x, int y) {
		Point p = new Point(x,y);
		int indice = -1;
		for (Point point : this.tab_mem) {
			indice += 1;
			if (p.distance(point) <= PERIPHERIE_CARRE_SELECTION) {
				return indice;
			}
		}
		return -1;
		
		
		

		
	}

}
