package modele;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;

/*
 * @author Loïck Nosal
 * Cette classe définit le modèle. 
 */
public class DessinModele extends Observable{
	
	
	private int nbf;
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
	
	public ArrayList<FigureColoree> get_fg(){
		return this.lfg;
	}
	/*
	 * initialise le dessin sans figures
	 */
	public void initDessinModele() {
		this.lfg = new ArrayList<FigureColoree>();
		this.sel = -1;
		setChanged();
		notifyObservers();
	}
	/*
	 * ajoute une figure dans le dessin
	 * @param f figure à ajouter
	 */
	public void ajoute(FigureColoree f) {
		this.deselectTous();
		if (f != null) {
			this.lfg.add(f);
			//f.selectionne();
		}
		setChanged();
		notifyObservers();
	}
	

	
	public void deselectTous() {
		if (this.lfg != null) {
			for (FigureColoree fg : this.lfg) {
				fg.deSelectionne();
			}
		}
		setChanged();
		notifyObservers();
		
	}
	
	
	public void update() {
		setChanged();
		notifyObservers();
	}
	
	public void setSel(int index) {
		this.sel = index;
	}
	
	public void changeCoul(FigureColoree fc, Color c) {
		fc.changeCouleur(c);
	}
	
	public void supprimerFigure() {
		if (this.sel != -1) {
			this.lfg.remove(sel);
		}
		this.update();
		this.sel = -1;
	}
	
	public void supprimerTout() {
		this.lfg.clear();
		update();
	}
	

}
