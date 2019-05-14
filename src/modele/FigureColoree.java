package modele;

import java.awt.Color;
import java.awt.Graphics;

/*
 * Cette classe abstraite repr�sente le sommet de
 *  la hi�rarchie d'h�ritage de n'importe quelle 
 *  figure g�om�trique visualisable � l'�cran et manipulable � la souris.
 *  @author Loick Nosal
 */
public class FigureColoree {
	
	private final static int TAILLE_CARRE_SELECTION = 10;
	private boolean selected;
	private Color couleur;
	protected Point[] tab_mem;
	
	
	public FigureColoree() {
		throw new Error("pas fait");
	}
	
	public int nbPoints() {
		throw new Error("pas fait");
	}
	
	public int nbClics() {
		throw new Error("pas fait");
	}
	
	public void modifierPoints(Point[] p) {
		throw new Error("pas fait");
	}

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
		throw new Error("pas fait");
	}
	
	

}
