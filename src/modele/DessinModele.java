package modele;

import java.util.ArrayList;
import java.util.Observable;

/*
 * @author Loïck Nosal
 * Cette classe définit le modèle. 
 */
public class DessinModele extends Observable{
	
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
		setChanged();
		notifyObservers();
	}
	/*
	 * ajoute une figure dans le dessin
	 * @param f figure à ajouter
	 */
	public void ajoute(FigureColoree f) {
		for (FigureColoree fg : lfg) {
			fg.deSelectionne();
		}
		if (f != null) {
			this.lfg.add(f);
			//f.selectionne();
		}
		setChanged();
		notifyObservers();
	}
	

}
