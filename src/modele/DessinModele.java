package modele;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;

/*
 * @author Loïck Nosal
 * Cette classe définit le modèle. 
 */
public class DessinModele extends Observable{
	
	/*
	 * Liste de figures colorées
	 */
	private int nbf;
	/*
	 * Indice de la figure actuellement sélectionnée (-1 si aucune figure n'est sélectionnée).
	 */
	private int sel;
	/*
	 * contient l'ensemble des figures dessinees par l'utilisateur dans un dessin
	 */
	private ArrayList<FigureColoree> lfg;
	
	/*
	 * constructeur vide qui initialise le dessin
	 */
	public DessinModele() {
		this.initDessinModele();
	}
	
	/*
	 * Getter de la liste de figures colorées
	 */
	public ArrayList<FigureColoree> get_fg(){
		return this.lfg;
	}
	/*
	 * initialise le dessin sans figures
	 */
	public void initDessinModele() {
		this.lfg = new ArrayList<FigureColoree>();
		this.sel = -1;
		this.nbf = 0;
		this.majAffichage();
	}
	/*
	 * ajoute une figure dans le dessin
	 * @param f figure à ajouter
	 */
	public void ajoute(FigureColoree f) {
		this.deselectTous();
		if (f != null) {
			this.lfg.add(f);
			this.nbf += 1;
		}
		this.majAffichage();
	}
	

	/*
	 * permet de deselectionner toutes les
	 * figures
	 */
	public void deselectTous() {
		if (this.lfg != null) {
			for (FigureColoree fg : this.lfg) {
				fg.deSelectionne();
			}
		}
		this.setSel(-1);
		this.majAffichage();
		
	}
	
	/*
	 * Mise à jour de l'affichage Opérations de sélection,
	 * déselection, changement de position, changement de couleur
	 */
	public void majAffichage() {
		setChanged();
		notifyObservers();
	}
	
	public void setSel(int i) {
		this.sel = i;
		
	}
	
	public void setNbf(int i) {
		this.nbf = i;
	}
	
	/*
	 * Cette méthode permet de changer la couleur de la figure passée en paramètre.
	 */
	public void changeCoul(FigureColoree fc, Color c) {
		fc.changeCouleur(c);
	}
	
	/*
	 * permet de supprimer une figure du dessin
	 */
	public void supprimerFigure() {
		if (this.sel != -1) {
			if (this.lfg.get(this.sel).isSelected() == true) {
				this.lfg.remove(sel);
				this.sel = -1;
				this.nbf -= 1;
			}
			
		}		
		this.majAffichage();
	}
	
	/*
	 * permet de supprimer l'ensemble des figures du dessin.
	 */
	public void supprimerTout() {
		this.lfg.clear();
		this.sel = -1;
		this.nbf = 0;
		this.majAffichage();
	}
	

}
