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
	public int nbPoints() {
		return 3;
	}
	
	@Override
	public int nbClics() {
		return 3;
	}
}
