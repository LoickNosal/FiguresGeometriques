package modele;

import java.util.ArrayList;
import java.util.Observable;

/*
 * @author Lo�ck Nosal
 * Cette classe d�finit le mod�le. 
 * Chaque instance de cette classe est un dessin comportant plusieurs 
 * figures color�es visualisables � l'�cran dont une seule est s�lectionn�e.
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
