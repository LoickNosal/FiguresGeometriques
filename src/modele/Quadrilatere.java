package modele;

/*
 * classe qui modélise un quadrilatere
 * @author Loick Nosal
 */
public class Quadrilatere extends Polygone{
	
	
	
	public Quadrilatere() {
		super();
	}
	
	/*
	 * Cette méthode retourne en résultat le nombre de points de mémorisation d'un quadrilatère
	 */
	public int nbPoints() {
		return 4;
	}
	
	public int nbClics() {
		return 4;
	}
}
