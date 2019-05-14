package modele;

import java.util.ArrayList;
import java.util.Observable;

/*
 * @author Loïck Nosal
 * Cette classe définit le modèle. 
 * Chaque instance de cette classe est un dessin comportant plusieurs 
 * figures colorées visualisables à l'écran dont une seule est sélectionnée.
 */
public class DessinModele extends Observable{
	
	private ArrayList<FigureColoree> lfg;
	
	
	public DessinModele() {
		throw new Error (" code non ecrit ");
	}
	
	public ArrayList<FigureColoree> get_fg(){
		throw new Error("pas fait");
	}
	
	public void initDessinModele() {
		throw new Error("pas fait");
	}
	
	public void ajoute(FigureColoree f) {
		throw new Error("pas fait");
	}
	

}
