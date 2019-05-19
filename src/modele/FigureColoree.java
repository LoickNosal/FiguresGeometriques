package modele;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/*
 * Cette classe abstraite représente les figures 
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
	public abstract boolean estDans(int x, int y);

	/*
	 * methode qui permet d'afficher une figure Coloree, et d'afficher
	 * les carres de selections si la figure est selectionnes
	 */
	public void afficher(Graphics g) {
	
		if (this.selected == true) {
			for (Point p : tab_mem) {
				int ab = p.rendreX() - (this.TAILLE_CARRE_SELECTION/2);
				int or = p.rendreY() - (this.TAILLE_CARRE_SELECTION/2);
				g.setColor(Color.red);
				g.fillRect(ab, or, TAILLE_CARRE_SELECTION, TAILLE_CARRE_SELECTION);

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
	
	

}
