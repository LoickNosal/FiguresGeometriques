package modele;

import java.awt.Color;
import java.awt.Graphics;

/*
 * Cette classe abstraite représente le sommet de
 *  la hiérarchie d'héritage de n'importe quelle 
 *  figure géométrique visualisable à l'écran et manipulable à la souris.
 *  @author Loick Nosal
 */
public abstract class FigureColoree {
	/*
	 * Constante definissant la taille des carres 
	* de selection. Utilisee par la methode "affiche".
	 */
	private static final int TAILLE_CARRE_SELECTION = 10;
	/*
	 * Attribut booleen indiquant si la figure est
	 * selectionnee (son affichage est alors different).
	 */
	private boolean selected;
	/*
	 * Attribut de type Color donnant la couleur de remplissage.
	 */
	private Color couleur;
	/*
	 * Tableau des points de memorisation de la figure.
	 */
	protected Point[] tab_mem;
	
	
	public FigureColoree() {
		this.selected = false;
		this.couleur = Color.black;
		this.tab_mem = new Point[this.nbPoints()];
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
	public abstract void modifierPoints(Point[] ps);

	public void afficher(Graphics g) {
		throw new Error("pas fait");
	}
	
	public void selectionne() {
		throw new Error("pas fait");
	}
	
	public void deSelectionne() {
		throw new Error("pas fait");
	}
	
	public void changeCouleur(Color c) {
		this.couleur = c;
	}
	
	

}
