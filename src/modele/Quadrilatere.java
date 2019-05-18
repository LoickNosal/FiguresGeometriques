package modele;

/*
 * classe qui modélise un quadrilatere
 * @author Loick Nosal
 */
public class Quadrilatere extends Polygone{
	
	
	/*
	 * constructeur vide
	 */
	public Quadrilatere() {
		super();
	}
	
	@Override
	/*
	 * Cette méthode retourne en résultat le nombre de points 
	 * de mémorisation d'un quadrilatère
	 */
	public int nbPoints() {
		return 4;
	}
	
	@Override
	public int nbClics() {
		return 4;
	}
}
