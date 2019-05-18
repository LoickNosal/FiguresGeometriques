package modele;

/*
 * classe qui mod�lise un quadrilatere
 * @author Loick Nosal
 */
public class Quadrilatere extends Polygone{
	
	
	
	public Quadrilatere() {
		super();
	}
	
	/*
	 * Cette m�thode retourne en r�sultat le nombre de points de m�morisation d'un quadrilat�re
	 */
	public int nbPoints() {
		return 4;
	}
	
	public int nbClics() {
		return 4;
	}
}
