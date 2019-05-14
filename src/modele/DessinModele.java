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
	
	/*
	 * contient l'ensemble des figures dessinees par l'utilisateur dans un dessin
	 */
	private ArrayList<FigureColoree> lfg;
	
	
	public DessinModele() {
		throw new Error (" code non ecrit ");
	}
	
	public ArrayList<FigureColoree> get_fg(){
		return this.lfg;
	}
	
	public void initDessinModele() {
		this.lfg = new ArrayList<FigureColoree>();
	}
	
	public void ajoute(FigureColoree f) {
		this.lfg.add(f);
	}
	

}
