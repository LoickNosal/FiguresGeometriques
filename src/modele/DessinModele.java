package modele;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;


/**
 * @author Lo�ck Nosal
 * Cette classe d�finit le mod�le. 
 */
public class DessinModele extends Observable implements Serializable{
	
	/**
	 * Liste de figures color�es
	 */
	private int nbf;
	/**
	 * Indice de la figure actuellement s�lectionn�e (-1 si aucune figure n'est s�lectionn�e).
	 */
	private int sel;
	/**
	 * contient l'ensemble des figures dessinees par l'utilisateur dans un dessin
	 */
	private ArrayList<FigureColoree> lfg;
	
	/**
	 * constructeur vide qui initialise le dessin
	 */
	public DessinModele() {
		this.initDessinModele();
	}
	
	/**
	 * Getter de la liste de figures color�es
	 */
	public ArrayList<FigureColoree> get_fg(){
		return this.lfg;
	}
	/**
	 * initialise le dessin sans figures
	 */
	public void initDessinModele() {
		this.lfg = new ArrayList<FigureColoree>();
		this.sel = -1;
		this.nbf = 0;
		this.majAffichage();
	}
	/**
	 * ajoute une figure dans le dessin
	 * @param f figure � ajouter
	 */
	public void ajoute(FigureColoree f) {
		this.deselectTous();
		if (f != null) {
			this.lfg.add(f);
			this.nbf += 1;
		}
		this.majAffichage();
	}
	

	/**
	 * permet de deselectionner toutes les figures
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
	
	/**
	 * Mise � jour de l'affichage Op�rations de s�lection,
	 * d�selection, changement de position, changement de couleur
	 */
	public void majAffichage() {
		setChanged();
		notifyObservers();
	}
	
	public void setSel(int i) {
		this.sel = i;
		
	}
	
	public int getSel(){
		
		return this.sel;
	}
	
	public void setNbf(int i) {
		this.nbf = i;
	}
	
	public int getNbf() {
		return this.nbf; 
	}
	
	/**
	 * Cette m�thode permet de changer la couleur de la figure pass�e en param�tre.
	 * @param fc figure pour laquelle on veut changer la couleur
	 * @param c couleur � appliquer � la figure
	 */
	public void changeCoul(FigureColoree fc, Color c) {
		fc.changeCouleur(c);
	}
	
	/**
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
	
	/**
	 * permet d'effacer une figure avec la gomme
	 * @param indice de la figure � effacer
	 */
	public void effacerFigure(int indice) {
		if (indice != -1) {
			if (indice < this.lfg.size()) {
				this.lfg.remove(indice);
				this.sel = -1;
				this.nbf -= 1;
			}		
		}
				
		this.majAffichage();
	}
	
	/**
	 * permet de supprimer l'ensemble des figures du dessin.
	 */
	public void supprimerTout() {
		this.lfg.clear();
		this.sel = -1;
		this.nbf = 0;
		this.majAffichage();
	}
	
	/**
	 * permet de sauvegarder le dessin dans un fichier
	 * @param dest fichier o� sauvegarder le dessin
	 */
	public void sauvegarder(File dest) throws FileNotFoundException, IOException {
		ObjectOutputStream d = new ObjectOutputStream(new FileOutputStream(dest));
		d.writeObject(this);
		d.close();
	}

	/**
	 * permet de charger un dessin depuis un fichier
	 * @param source fichier depuis lequel charger le dessin
	 * @return DessinModele charg�
	 */
	public DessinModele charger(File source) throws IOException, ClassNotFoundException{
		
		ObjectInputStream di = new ObjectInputStream(new FileInputStream(source));
		DessinModele p = (DessinModele)(di.readObject());
		p.setSel(-1);
		di.close();
		
		return p;
		
	}
	

}
