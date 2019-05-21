package modele;

/*
 * @author Nosal Lo�ck
 * Classe mod�lisant les triangles
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
	 * Cette m�thode retourne en r�sultat le nombre de points de m�morisation d'un triangle.
	 */
	public int nbPoints() {
		return 3;
	}
	
	@Override
	public int nbClics() {
		return 3;
	}
}
