package modele;

/*
 * @author Nosal Loïck
 * Classe modélisant les triangles
 */
public class Triangle extends Polygone{

	/*
	 * Constructeur vide
	 */
	public Triangle(){
		super();
	}
	
	
	@Override
	/*
	 * Cette méthode retourne en résultat le nombre de points de mémorisation d'un triangle.
	 */
	public int nbPoints() {
		return 3;
	}
	
	@Override
	public int nbClics() {
		return 3;
	}
}
